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

public class LoadingDialogFragment extends DialogFragment {

    public static LoadingDialogFragment newInstance() {

        Bundle args = new Bundle();

        LoadingDialogFragment fragment = new LoadingDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_loading, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
        getDialog().getWindow().setBackgroundDrawable(colorDrawable);
        setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme);
    }

    public  void dismissDialog(){
        getDialog().dismiss();
    }



}
