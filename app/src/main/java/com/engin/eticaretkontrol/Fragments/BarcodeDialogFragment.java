package com.engin.eticaretkontrol.Fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.engin.eticaretkontrol.R;

public class BarcodeDialogFragment extends DialogFragment {

    int state;

    public BarcodeDialogFragment(int state){
        this.state = state;
    }

    public static BarcodeDialogFragment newInstance(int state) {

        Bundle args = new Bundle();
        BarcodeDialogFragment fragment = new BarcodeDialogFragment(state);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        if (state == 1){
            root = inflater.inflate(R.layout.dialog_fragment_barcode_ok,container,false);
        }
        else if(state == 0){
            root =inflater.inflate(R.layout.dialog_fragment_barcode_failed,container,false);
        }
        else{
            root = inflater.inflate(R.layout.dialog_fragment_barcode_failed2,container,false);
        }
        return  root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
        getDialog().getWindow().setBackgroundDrawable(colorDrawable);
        setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme);
    }


}
