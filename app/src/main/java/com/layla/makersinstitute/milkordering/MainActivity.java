package com.layla.makersinstitute.milkordering;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView quantityTextView, totalPriceTextView;
    Button showTotalPriceButton;
    int totalPriceOfOrderMilk = 0;
    int quantityOfMilk = 0;
    final int priceOfMilk = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTextView = (TextView) findViewById(R.id.quantityMilkTexrView);
        totalPriceTextView = (TextView) findViewById(R.id.priceOfMilk);
        showTotalPriceButton = (Button) findViewById(R.id.showTotalPriceButton);

        visibility();
    }

    public void incrementOrder(View view) {
        if (quantityOfMilk < 20) {
            quantityOfMilk += 1;
            quantityTextView.setText("" + quantityOfMilk);
            Log.d("incrementOrder", "" + quantityOfMilk);
        } else {
            Log.d("incrementOrder", "quantity lebih dari 20");
        }
        visibility();
    }

    public void decrementOrder(View view) {
        if (quantityOfMilk > 0) {
            quantityOfMilk -= 1;
            quantityTextView.setText("" + quantityOfMilk);
            Log.d("decrementOrder", "" + quantityOfMilk);
        } else {
            Log.d("decrement", "quantity kurang dari 0");
        }
        visibility();
    }

    public void showTotalPrice(View view) {
        totalPriceOfOrderMilk = priceOfMilk * quantityOfMilk;

        totalPriceTextView.setText(" $ " + totalPriceOfOrderMilk);
        Log.v("showTotalPrice", "$" + totalPriceOfOrderMilk);
    }

    public void reset(View view) {
        quantityOfMilk = 0;
        totalPriceOfOrderMilk = 0;
        quantityTextView.setText("" + quantityOfMilk);
        totalPriceTextView.setText("$" + totalPriceOfOrderMilk);
        Log.v("Reset", "Please Reset");
    }

    public void visibility() {
        if (quantityOfMilk == 0) {
            showTotalPriceButton.setEnabled(false);
        } else {
            showTotalPriceButton.setEnabled(true);
        }
    }
}

