package edu.miracostacollege.cs134.costalattacars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

import edu.miracostacollege.cs134.costalattacars.R;
import edu.miracostacollege.cs134.costalattacars.model.CarLoan;

public class MainActivity extends AppCompatActivity {


    /* Create references to 2 editTexts and 1 radio goup */
    private EditText carPriceET;
    private EditText downPaymentET;
    private RadioGroup loanTermRadioGroup;

    // Make a reference to model (CarLoan)
    private CarLoan loan;



    // Currency and Percentage Formatting:
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // link controller var's to the views
        carPriceET = findViewById(R.id.carPriceEditText);
        downPaymentET = findViewById(R.id.downPaymentEditText);
        loanTermRadioGroup = findViewById(R.id.loanTermRadioGroup);


        // instantiate a new CarLoan
        loan = new CarLoan();
    }

    public void switchToLoanSummary(View v) {

        /*todo: extract data from 2 edit texts and radio button
            update the model CarLoan
            create a new Intent to share data
            Start new activity
            */


            // STEP 1: extract data from 2 edit texts and radio group
        double carPrice = Double.parseDouble(carPriceET.getText().toString());
        double downPayment = Double.parseDouble(downPaymentET.getText().toString());

        int loanTerm =3;
            // use a switch statement to determine radio button checked in radio group
        switch (loanTermRadioGroup.getCheckedRadioButtonId())
        {

            case R.id.threeYearsRadioButton:
                loanTerm =3;
                break;

            case R.id.fourYearsRadioButton:
                loanTerm = 4;
                break;

            case R.id.fiveYearsRadioButton:
                loanTerm = 5;
                break;

        }


            // STEP 2: Update the model CarLoan (object: loan)
        loan.setPrice(carPrice);
        loan.setDownPayment(downPayment);
        loan.setLoanTerm(loanTerm);



            // STEP 3: Create a new "Intent" to share the data between activities
                                                // two param's: start activity, destination activity
        Intent loanSummaryIntent = new Intent(this, LoanSummaryActivity.class);

        // Now share the data! (not fun?)
        loanSummaryIntent.putExtra("monthlyPayment", currency.format(loan.monthlyPayment()));
        loanSummaryIntent.putExtra("carPrice", currency.format(loan.getPrice()));
        loanSummaryIntent.putExtra("salesTax", currency.format(loan.taxAmount()));
        loanSummaryIntent.putExtra("downPayment", currency.format(loan.getDownPayment()));




    }
}
