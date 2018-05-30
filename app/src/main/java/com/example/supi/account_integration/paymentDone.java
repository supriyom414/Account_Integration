package com.example.supi.account_integration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class paymentDone extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_done);

        textView = findViewById(R.id.textView);
        textView.setText("HELLO USER YOUR PAYMENT IS SUCCESFULL!!");
    }
}
