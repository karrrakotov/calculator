package com.example.happycalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private boolean checkZeroScreen = true;
    private String operator = "";
    private String firstNumber;
    private final String FORMAT = "#0.0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView3);
    }

    public void clickNumber(View view) {
        if (checkZeroScreen) textView.setText("");

        checkZeroScreen=false;
        String number = textView.getText().toString();

        switch (view.getId()) {

            case R.id.button13:
                number += "1";
                number = zeroIsFirst(number) ? number.substring(1) : number;
                break;

            case R.id.button14:
                number += "2";
                number = zeroIsFirst(number) ? number.substring(1) : number;
                break;

            case R.id.button15:
                number += "3";
                number = zeroIsFirst(number) ? number.substring(1) : number;
                break;

            case R.id.button9:
                number += "4";
                number = zeroIsFirst(number) ? number.substring(1) : number;
                break;

            case R.id.button10:
                number += "5";
                number = zeroIsFirst(number) ? number.substring(1) : number;
                break;

            case R.id.button11:
                number += "6";
                number = zeroIsFirst(number) ? number.substring(1) : number;
                break;

            case R.id.button5:
                number += "7";
                number = zeroIsFirst(number) ? number.substring(1) : number;
                break;

            case R.id.button6:
                number += "8";
                number = zeroIsFirst(number) ? number.substring(1) : number;
                break;

            case R.id.button7:
                number += "9";
                number = zeroIsFirst(number) ? number.substring(1) : number;
                break;

            case R.id.button17:
                number = zeroIsFirst(number) && number.length() == 1 ? "0" : number + "0";
                break;

            case R.id.button18:
                number = dotIsPresent(number) ? number : number + ".";
                break;

            case R.id.button2:
                number = numberIsZero(number) ? "0" : minusIsPresent(number) ? number.substring(1) : "-" + number;
                break;
        }

        textView.setText(number);
    }

    private boolean zeroIsFirst(String number) {
        if (number.equals("")) return true;

        boolean result = Character.toString(number.charAt(0)).equals("0") ? true : false;

        return result;
    }

    private boolean dotIsPresent(String number) {
        boolean result = number.indexOf(".") == -1 ? false : true;

        return result;
    }

    private boolean numberIsZero(String number) {
        boolean result = number.equals("0") || number.equals("") ? true : false;

        return result;
    }

    private boolean minusIsPresent(String number) {
        boolean result = number.charAt(0) == '-' ? true : false;

        return result;
    }

    public void acClick(View view) {
        textView.setText("0");
        checkZeroScreen = true;
    }

    public void operation(View view) {
        checkZeroScreen = true;
        firstNumber = textView.getText().toString();

        switch (view.getId()) {
            case R.id.button12: operator="-"; break;
            case R.id.button16: operator="+"; break;
            case R.id.button4:  operator="/"; break;
            case R.id.button8: operator="*" ; break;
        }
    }

    public void clickPercent(View view) {

        if(operator == "") {
            String number = textView.getText().toString();
            double temt = Double.parseDouble(number) / 100;
            number = String.valueOf(temt);

            textView.setText(number);
        } else {
            String newNumber = textView.getText().toString();
            double result = 0.0d;
            switch (operator) {
                case "+": result = Double.parseDouble(firstNumber) + Double.parseDouble(firstNumber) * Double.parseDouble(newNumber) /100; break;
                case "-": result = Double.parseDouble(firstNumber) - Double.parseDouble(firstNumber) * Double.parseDouble(newNumber) /100; break;
                case "/": result = Double.parseDouble(firstNumber) / Double.parseDouble(newNumber) * 100; break;
                case "*": result = Double.parseDouble(firstNumber) * Double.parseDouble(newNumber) / 100; break;
            }
            textView.setText(String.valueOf(result));
            operator = "";
        }
    }

    public void clickEqual(View view) {
        String newNumber = textView.getText().toString();
        double result = 0.0d;

        switch (operator) {
            case "-": result = Double.parseDouble(firstNumber) - Double.parseDouble(newNumber); break;
            case "+": result = Double.parseDouble(firstNumber) + Double.parseDouble(newNumber); break;
            case "/": result = Double.parseDouble(firstNumber) / Double.parseDouble(newNumber); break;
            case "*": result = Double.parseDouble(firstNumber) * Double.parseDouble(newNumber); break;
        }

        String formattedDouble = new DecimalFormat(FORMAT).format(result);

        textView.setText(formattedDouble);
    }


}
