package com.example.android.just_java;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice(quantity,5);
        String message = "Name : Nour el houda";
        message += "\nQuantity : " + quantity;
        message += "\nTotal: $" + price ;
        message +="\nThank you!";
        displayMessage(message);
    }

    private int calculatePrice(int quantity, int pricePerCup) {
        int price = quantity * pricePerCup;
        return price;
    }

    public void increment(View view){
        quantity ++;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        quantity --;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
        Toast.makeText(this, "Order Summary", Toast.LENGTH_SHORT).show();
    }
}
