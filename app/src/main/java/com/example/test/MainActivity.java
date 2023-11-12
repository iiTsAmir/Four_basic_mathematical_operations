package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Objects.requireNonNull(getSupportActionBar()).setTitle("");

        EditText number1 = findViewById(R.id.text1);
        TextView mark = findViewById(R.id.mark);
        EditText number2 = findViewById(R.id.text2);
        TextView result = findViewById(R.id.textView2);
        Button sum = findViewById(R.id.sum);
        Button subtraction = findViewById(R.id.subtraction);
        Button multiply = findViewById(R.id.multiply);
        Button division = findViewById(R.id.division);
        Button clear = findViewById(R.id.clear);

        String error = "enter number";

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isntNumber(number1.getText()+"") || isntNumber(number2.getText()+"")) {
                    result.setText(error);
                    return;
                }

                float num1 = Float.parseFloat(number1.getText()+"");
                float num2 = Float.parseFloat(number2.getText()+"");

                float num3 = num1 + num2 ;

                mark.setText("+");

                if (checkDecimal(num3))
                    result.setText(String.valueOf(num3));
                else
                    result.setText(String.format("%.0f", num3));

            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isntNumber(number1.getText()+"") || isntNumber(number2.getText()+"")) {
                    result.setText(error);
                    return;
                }

                float num1 = Float.parseFloat(number1.getText()+"");
                float num2 = Float.parseFloat(number2.getText()+"");

                float num3 = num1 - num2 ;

                mark.setText("-");

                if (checkDecimal(num3))
                    result.setText(String.valueOf(num3));
                else
                    result.setText(String.format("%.0f", num3));

            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isntNumber(number1.getText()+"") || isntNumber(number2.getText()+"")) {
                    result.setText(error);
                    return;
                }

                float num1 = Float.parseFloat(number1.getText()+"");
                float num2 = Float.parseFloat(number2.getText()+"");

                float num3 = num1 * num2 ;

                mark.setText("×");

                if (checkDecimal(num3))
                    result.setText(String.valueOf(num3));
                else
                    result.setText(String.format("%.0f", num3));

            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isntNumber(number1.getText()+"") || isntNumber(number2.getText()+"")) {
                    result.setText(error);
                    return;
                }

                float num1 = Float.parseFloat(number1.getText()+"");
                float num2 = Float.parseFloat(number2.getText()+"");

                float num3 = num1 / num2 ;

                mark.setText("÷");

                if (checkDecimal(num3))
                    result.setText(String.valueOf(num3));
                else
                    result.setText(String.format("%.0f", num3));

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number1.setText("");
                mark.setText("");
                number2.setText("");
                result.setText("");
            }
        });


    }

    private boolean isntNumber (String input){

        String regex = "-?[0-9]+[.]?[0-9]*";
        return !Pattern.matches(regex,input);

    }

    private boolean isNumberWsc (String input){
        Scanner sc = new Scanner(input);
        return sc.hasNextFloat();
    }


    private boolean checkDecimal (float input){

        String regex = "-?[0-9]+[.]+0*";
        return !Pattern.matches(regex,input+"");

    }

}