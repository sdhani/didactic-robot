/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    String sides = "";
    String name = "";
    boolean hasWhippedCream = false;
    boolean hasChocolate = false;
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //runs layout, parses XML into
        // Java Objects to update the activity.
    }

    //increment quantity by one
    public void increment(View view) {
        if (quantity == 100) {
            displayQuantity(quantity);
        } else {
            quantity++;
            displayQuantity(quantity);
        }
    }

    //decrement quantity by one
    public void decrement(View view) {
        if (quantity == 0) {
            displayQuantity(quantity);
        } else {
            quantity--;
            displayQuantity(quantity);
        }
    }

    //checks if customer wants whipped cream
    public void whippedCream(View view) {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_check_box);
        if (whippedCream.isChecked()) {
            hasWhippedCream = true;
            sides += "\n w/ Whipped Cream";
        }else{
            hasWhippedCream = false;
            sides += "";
        }
    }

    //checks if customer wants chocolate
    public void chocolate(View view) {
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_check_box);
        if (chocolate.isChecked()) {
            hasChocolate = true;
            sides = "\n w/ Chocolate";
        }else{
            hasChocolate = false;
            sides = "";
        }
    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice() {
        int total = 0;
        int whippedCream = 1;
        int chocolate = 2;

        if(hasWhippedCream && hasChocolate){
            total = quantity * (5 + whippedCream + chocolate);
        }else if(hasChocolate){
            total = quantity * (5 + chocolate);
        }else if(hasWhippedCream){
            total = quantity * (5 + whippedCream);
        }else{
            total = quantity * 5;
        }

        return total;
    }
    //R class.Resource Type(i.e. drawable).NameOfFile

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.amount_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    private String createOrderSummary(int totalPrice) {
        EditText nameInput = (EditText) findViewById(R.id.name_edit_text);
        name = nameInput.getText().toString();

        return "Name: " + name +
                "\nQuantity: " + quantity + sides +
                "\nTotal: $" + totalPrice +
                "\nThank You!";
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO );
        intent.setData(Uri.parse("mailto:")); // only email apps should handle
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name); // specify the email's subject
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(calculatePrice())); // writes the body of the email

        if (intent.resolveActivity(getPackageManager()) != null){
            /*if there is an activity on the  device where
            it is safe to run the intent, run the intent, else don't*/
            startActivity(intent);
        }
    }

}

/*  Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setData(Uri.parse("geo:47.6, -122.3"));
    if (intent.resolveActivity(getPackageManager()) != null){
        startActivity(intent);
    }
*/