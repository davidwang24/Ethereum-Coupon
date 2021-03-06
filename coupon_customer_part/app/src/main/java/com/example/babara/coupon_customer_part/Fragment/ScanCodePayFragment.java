package com.example.babara.coupon_customer_part.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.babara.coupon_customer_part.R;
import com.example.babara.coupon_customer_part.zxing.activity.CaptureActivity;
import com.google.zxing.integration.android.IntentIntegrator;

import static android.app.Activity.RESULT_OK;


public class ScanCodePayFragment extends Fragment implements View.OnClickListener{
    public ScanCodePayFragment(){
    }

    private Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scan_code_pay,container,false);
        button = (Button)view.findViewById(R.id.scan);
        button.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v){
        //扫描操作

        Intent intent = new Intent(getActivity(), CaptureActivity.class);
        startActivity(intent);
//        IntentIntegrator integrator = new IntentIntegrator(getActivity());
//        integrator.initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            button.setText(result);
        }
    }
}
