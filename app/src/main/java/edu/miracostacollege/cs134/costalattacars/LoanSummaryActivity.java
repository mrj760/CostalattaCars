package edu.miracostacollege.cs134.costalattacars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoanSummaryActivity extends AppCompatActivity {


    // create the reference views
    private TextView monthlyPaymentTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        // set them
        monthlyPaymentTV = findViewById(R.id.monthlyPaymentTextView);


        // 1) Receive the intent from MainActivity
        Intent intent = getIntent();


        // 2) Populate all the textViews
        monthlyPaymentTV.setText(((Intent) intent).getStringExtra("monthlyPayment"));



    }


    public void closeActivity(View v) {
        this.finish();
    }
}
