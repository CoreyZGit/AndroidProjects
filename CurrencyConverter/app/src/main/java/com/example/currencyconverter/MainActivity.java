package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private InputMethodManager inputManager;
    private EditText amountText;
    private EditText convertedText;
    private RadioGroup radioGroup;
    private RadioButton selectedButton;
    private Button convertButton;
    private EditText amountInput;
    private String amountConverted;
    Intent designedByActivity;
    public static ImageView currencyImage;


    public void rgClick(View view){

        int radioId = radioGroup.getCheckedRadioButtonId();
        selectedButton = findViewById(radioId);
        amountInput.setEnabled(true);
        inputManager.toggleSoftInputFromWindow(amountInput.getWindowToken(), InputMethodManager.SHOW_FORCED, 0);
        amountInput.requestFocus();

    }

    public void imageClick(View view){

        currencyImage.setEnabled(false);
        designedByActivity = new Intent(this, DesignedBy.class);
        startActivity(designedByActivity);

    }

    public void convertCurrency(View view){

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

        amountText = findViewById(R.id.amountInput);
        convertedText = findViewById(R.id.displayAmount);

        if(amountText.getText().toString().equals("")) {

            convertedText.setText("");
            Log.i("Info", "No value entered");

        }

        else{

            double amountInDollars = Double.parseDouble(amountText.getText().toString());

            if (selectedButton.getText().toString().equals("Euro")) {

                amountConverted = String.format("%.2f", amountInDollars * 0.92);

            }

            if (selectedButton.getText().equals("Pounds")) {

                amountConverted = String.format("%.2f", amountInDollars * 0.85);

            }

            if (selectedButton.getText().equals("Yen")) {

                amountConverted = String.format("%.2f", amountInDollars * 111.30);

            }

            convertedText.setText(amountConverted);

            Log.i("Info", amountInDollars + " USD converted to " + amountConverted + " pounds");
        }


    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        convertButton = findViewById(R.id.convertButton);
        amountInput = findViewById(R.id.amountInput);
        inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        currencyImage = findViewById(R.id.currencyImage);
        inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);


        amountInput.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {

                if (amountInput.getText().toString().equals("")) {

                    convertButton.setEnabled(false);

                }else {

                    convertButton.setEnabled(true);

                }
            }
        });

    }
}
