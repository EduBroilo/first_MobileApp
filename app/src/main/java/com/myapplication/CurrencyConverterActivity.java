package com.myapplication;

import java.text.DecimalFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CurrencyConverterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_currency_converter);

        EditText inputNumber = findViewById(R.id.edit_BRL);
        EditText outputNumber = findViewById(R.id.edit_USD);
        Button converter_button = findViewById(R.id.button_Converter);

        DecimalFormat decimalFormat = new DecimalFormat("#..00");

        converter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputNumber.getText().toString();

                // TO-DO: Get value by API
                double USD_value = 5.57;

                if (!TextUtils.isEmpty(input)) {
                    // Converter para Número
                    try {
                        double number = Double.parseDouble(input);

                        double result = number / USD_value;

                        outputNumber.setText(decimalFormat.format(result));
                    }catch (NumberFormatException e) {
                        // inválido

                    }
                }
            }
        });
    }
}