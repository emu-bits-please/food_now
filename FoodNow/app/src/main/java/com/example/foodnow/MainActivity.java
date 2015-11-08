package com.example.foodnow;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    APIWrapper BOOM = new APIWrapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final FloatingActionButton infoButton = (FloatingActionButton) findViewById(R.id.infoButton);
        infoButton.setEnabled(false);
        infoButton.setVisibility(View.INVISIBLE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView confirmationText = (TextView) findViewById(R.id.confirmText);
        final Button newOrderButton = (Button) findViewById(R.id.newOrderButton);
        newOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoButton.setVisibility(View.INVISIBLE);
                infoButton.setEnabled(false);
                confirmationText.setVisibility(View.INVISIBLE);
                newOrderButton.setVisibility(View.INVISIBLE);
            }
        });

        final Button orderButton = (Button) findViewById(R.id.orderButton);
        orderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ViewPropertyAnimator buttonSpin = orderButton.animate();
                buttonSpin.rotationBy((float)360);
                BOOM.doAPICALL(infoButton);
                confirmationText.setVisibility(View.VISIBLE);
                newOrderButton.setVisibility(View.VISIBLE);
            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String orderedItemDetails = "Item: " +
                        BOOM.getFoodItemName() +
                        "\nPrice: " + BOOM.getFoodPrice() +
                        "\nMerchant: " +
                        BOOM.getMerchantName() +
                        "\n" + BOOM.getAddress();
                new AlertDialog.Builder(context)
                        .setTitle("Ordered Item")
                        .setMessage(orderedItemDetails)
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setIcon(android.R.drawable.ic_menu_info_details)
                        .show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
