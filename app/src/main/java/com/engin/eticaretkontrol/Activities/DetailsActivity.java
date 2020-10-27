package com.engin.eticaretkontrol.Activities;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.engin.eticaretkontrol.Adapters.DetailsAdapter;
import com.engin.eticaretkontrol.ConfigData;
import com.engin.eticaretkontrol.Fragments.BarcodeDialogFragment;
import com.engin.eticaretkontrol.Fragments.LoadingDialogFragment;
import com.engin.eticaretkontrol.NetProgress.Models.Order;
import com.engin.eticaretkontrol.NetProgress.Models.OrderItem;
import com.engin.eticaretkontrol.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.apache.commons.collections4.CollectionUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "DetailsActivity";
    TextView costumerName,date;
    ImageView scan;
    RecyclerView detailsRV;
    List<OrderItem> productsList;
    List<OrderItem> collectedProducts = new ArrayList<>();
    DetailsAdapter detailsAdapter;
    SharedPreferences listPreferences;
    BarcodeDialogFragment barcodeDialogFragment;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initVariable();
        //Getting order from OrdersTabActivity and local list from memory
        Order order = getIntent().getParcelableExtra("Order");
        List<Order> localList=ConfigData.getList(listPreferences,"localList");
        //finding Orginal order
        int index = Order.findItem(order,localList);
        //chagecing collected state in local list
        Log.i(TAG, "Changing collected state");
        order.collectedState = 2;
        localList.set(index,order);
        ConfigData.setList(listPreferences,"localList",localList);
        Log.i(TAG, "Local list changed");
        // order information showing...
        costumerName.setText(order.getCustomerFirstname().toUpperCase()+" "+order.getCustomerSurname().toUpperCase());
        date.setText(order.getCreatedAt());
        // setting RV
        productsList =order.getOrderItems();
        detailsRV.setHasFixedSize(true);
        detailsRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        detailsAdapter = new DetailsAdapter(productsList,getApplicationContext());
        detailsRV.setAdapter(detailsAdapter);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanBarcode();
            }
        });

    }

    public void initVariable(){
        costumerName = findViewById(R.id.detailsName);
        date = findViewById(R.id.detailsDate);
        scan = findViewById(R.id.productScan);
        detailsRV = findViewById(R.id.detailsRV);
        listPreferences = getSharedPreferences("list",0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DetailsActivity.this,OrdersTabActivity.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }

    public void scanBarcode(){
        IntentIntegrator intentIntegrator =new IntentIntegrator(this);
        intentIntegrator.setCaptureActivity(CaptureAct.class);
        intentIntegrator.setOrientationLocked(false);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
        intentIntegrator.setPrompt("Barkod Aranıyor...");
        intentIntegrator.initiateScan();

    }

    private void showProgressDialog(int state){
        barcodeDialogFragment = BarcodeDialogFragment.newInstance(state);
        barcodeDialogFragment.show(getSupportFragmentManager(),"");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        IntentResult result= IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (result != null && result.getContents() != null){
               String resultContents = result.getContents();
               Log.w(TAG, "Result is  not null"+resultContents );
               for(OrderItem orderItem : productsList) {
                   if(orderItem.getProductBarcode().equals(resultContents)){
                       int ix = OrderItem.findItem(orderItem,productsList);
                       orderItem.collectedState = true;
                       collectedProducts.add(orderItem);
                       productsList.set(ix,orderItem);
                       detailsAdapter.notifyDataSetChanged();
                       AlertDialog.Builder builder = new AlertDialog.Builder(this);
                       builder.setMessage("Bu Üründen "+ orderItem.getProductQuantity().toString()+" Adet Alınız.");
                       builder.setTitle("UYARI");
                       builder.setIcon(R.drawable.ic_baseline_warning_24);
                       builder.setPositiveButton("Devam Et", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               scanBarcode();
                               }
                       });
                       builder.setNegativeButton("Vazgeç", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               startActivity(new Intent(DetailsActivity.this,OrdersTabActivity.class));
                               overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                               finish();
                           }
                       });
                       AlertDialog dialog =builder.create();
                       dialog.setCanceledOnTouchOutside(true);
                       dialog.show();

                   }
                   if (CollectionUtils.isEqualCollection(collectedProducts,productsList)){
                       new Handler(new Handler.Callback() {
                           @Override
                           public boolean handleMessage(@NonNull Message message) {
                               showProgressDialog(1);
                               return true;
                           }
                       }).sendEmptyMessage(0);
                       Toast.makeText(this,"Liste Tamamlandı",Toast.LENGTH_SHORT).show();
                   }
               }
               }

        else{
           new Handler(new Handler.Callback() {
                @Override
                public boolean handleMessage(@NonNull Message message) {
                    showProgressDialog(0);
                    return true;
                }
            }).sendEmptyMessage(0);
            Toast.makeText(this,"Barkod Okunamadı",Toast.LENGTH_SHORT).show();

        }

    }


}