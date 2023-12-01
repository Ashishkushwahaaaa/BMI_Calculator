package com.hexabytes.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightft,edtHeightin;
        Button btnCalculate;
        TextView txtresult;

        edtWeight = findViewById(R.id.edtweight);
        edtHeightft = findViewById(R.id.edtHeightft);
        edtHeightin = findViewById(R.id.edtHeightin);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtresult = findViewById(R.id.txtresult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int W = Integer.parseInt(edtWeight.getText().toString());
                    int ft = Integer.parseInt(edtHeightft.getText().toString());
                    int In = Integer.parseInt(edtHeightin.getText().toString());

                    double totalIn = ft * 12 + In;
                    double totalCm = totalIn * 2.53;
                    double totalM = totalCm / 100;
                    double bmi = W / (totalM * totalM);
                    float BMI = (float)(bmi);
                    if (BMI > 25) {
                        txtresult.setText("     "+BMI+ "\n" + "You're Overweight");
                        txtresult.setBackgroundColor(Color.YELLOW);

                    } else if (BMI < 18) {
                        txtresult.setText("     "+BMI+ "\n" + "You're Underweight!");
                        txtresult.setBackgroundColor(Color.RED);
                    } else {
                        txtresult.setText("     "+BMI+ "\n" + "You're Healthy!!");
                        txtresult.setBackgroundColor(Color.GREEN);

                    }
                }catch(Exception e){
                    txtresult.setText("Can't Calculate");
                }
            }
        });

    }
}