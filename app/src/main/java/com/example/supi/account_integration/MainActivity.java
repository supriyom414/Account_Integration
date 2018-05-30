package com.example.supi.account_integration;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;

public class MainActivity extends AppCompatActivity implements BillingProcessor.IBillingHandler {

    BillingProcessor bp;
    private Button pay, go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this is for if i have license from google console
        //bp = new BillingProcessor(this, "",this);
        //this is for testing
        bp = new BillingProcessor(this, null,this);

        pay = findViewById(R.id.pay);
        go = findViewById(R.id.go);

        go.setVisibility(View.INVISIBLE);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bp.purchase(MainActivity.this,"android.test.purchased");
            }
        });

    }

    @Override
    public void onProductPurchased(@NonNull String productId, @Nullable TransactionDetails details) {

        pay.setVisibility(View.INVISIBLE);
        go.setVisibility(View.VISIBLE);

    }

    @Override
    public void onPurchaseHistoryRestored() {

    }

    @Override
    public void onBillingError(int errorCode, @Nullable Throwable error) {

    }

    @Override
    public void onBillingInitialized() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (!bp.handleActivityResult(requestCode, resultCode, data)){
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onDestroy(){
        if (bp != null){
            bp.release();
        }
        super.onDestroy();
    }
}