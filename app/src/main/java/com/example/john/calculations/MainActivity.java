package com.example.john.calculations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        // Declaring the tax factor for calculations. It is a constant.
    private static final double VAT_FACTOR = 1.2;
    // declaring variables of types EditText and RadioButton.
    private EditText price_input;
    private EditText unit_input;
    private RadioButton excl, incl;
    double price = 0;
    double vat_price = price * VAT_FACTOR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        price_input = findViewById(R.id.unit_price);
        unit_input = findViewById(R.id.unit_number);
        excl = findViewById(R.id.exclusive);
        incl = findViewById(R.id.inclusive);
    }

    public static double exlVAT (double price) { return price; }
    public static double inclVAT (double vat_price) { return vat_price; }

    public void onClick (View view) {
        if (view.getId() == R.id.clear) { price_input.setText(""); unit_input.setText(""); }
        else if (view.getId() == R.id.ok) {}

        double value = Double.parseDouble(price_input.getText().toString());
        if (excl.isChecked()) price_input.setText(String.valueOf(exlVAT(value)));
        else price_input.setText(String.valueOf(inclVAT(value)));

    }
}
