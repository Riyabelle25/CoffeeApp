package com.example.justjava;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;


    public class MainActivity extends AppCompatActivity {

        int quantity = 2; char order_summary_email_subject; char order_summary_name;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        /**
         * This method is called when the plus button is clicked.
         */
        public void increment(View view) {
            if (quantity == 100) {
                return;
            }
            quantity = quantity + 1;
            displayQuantity(quantity);
        }

        /**
         * This method is called when the minus button is clicked.
         */
        public void decrement(View view) {
            if (quantity == 0) {
                return;
            }
            quantity = quantity - 1;
            displayQuantity(quantity);
        }

        /**
         * This method is called when the order button is clicked.
         */
        public void submitOrder(View view) {
            // Get user's name
            EditText nameField = (EditText) findViewById(R.id.name_field);
            Editable nameEditable = nameField.getText();
            String name = nameEditable.toString();

            // Figure out if the user wants whipped cream topping
            CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
            boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

            // Figure out if the user wants choclate topping
            CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
            boolean hasChocolate = chocolateCheckBox.isChecked();

            // Calculate the price
            int price = calculatePrice(hasWhippedCream, hasChocolate);

            // Display the order summary on the screen
            String message = createOrderSummary(name, price, hasWhippedCream, hasChocolate);

            // Use an intent to launch an email app.
            // Send the order summary in the email body.
                 int numberOfEmailsInInbox = 0;
            int numberOfDraftEmails = 2;
            String emailMessage = "You have " + numberOfEmailsInInbox + " emails. ";
             String draftMessage = "You have " + numberOfDraftEmails + " email drafts.";
             if (numberOfEmailsInInbox == 0) {
            emailMessage = "You have no new messages. ";
               }

             if (numberOfDraftEmails == 0) {
             draftMessage = "You have no new drafts.";
              }

             Log.v("InboxActivity", emailMessage);
             Log.v("InboxActivity", draftMessage);



        }

        /**
         * Calculates the price of the order.
         *
         * @param addWhippedCream is whether or not we should include whipped cream topping in the price
         * @param addChocolate    is whether or not we should include chocolate topping in the price
         * @return total price
         */
        private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
            // First calculate the price of one cup of coffee
            int basePrice = 5;

            // If the user wants whipped cream, add $1 per cup
            if (addWhippedCream) {
                basePrice = basePrice + 1;
            }

            // If the user wants chocolate, add $2 per cup
            if (addChocolate) {
                basePrice = basePrice + 2;
            }

            // Calculate the total order price by multiplying by the quantity
            return quantity * basePrice;
        }

        /**
         * Create summary of the order.
         *
         * @param name            on the order
         * @param price           of the order
         * @param addWhippedCream is whether or not to add whipped cream to the coffee
         * @param addChocolate    is whether or not to add chocolate to the coffee
         * @return text summary
         */
       private String createOrderSummary(price,quantity,addWhippedCream,addChocolate) {
        String priceMessage = "Name: Lilly ";
        priceMessage += "\nAdd Whipped Cream?" + addWhippedCream;
        priceMessage += "\nAddchoclate? " + addChocolate;
        priceMessage += "\nquantity" + quantity;
        priceMessage += "\nTotal: $"+ price;
                //NumberFormat.getCurrencyInstance().format(price));
        priceMessage += "\nthank_you";
        return priceMessage;
    }


        /**
         * This method displays the given quantity value on the screen.
         */
        private void displayQuantity(int numberOfCoffees) {
            TextView quantityTextView = (TextView) findViewById(
                    R.id.quantity_text_view);
            quantityTextView.setText("" + numberOfCoffees);
        }
        /**
         * This method displays the given price on the screen.
         */
        private void displayPrice(int number) {
            TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
            priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        }

    }





