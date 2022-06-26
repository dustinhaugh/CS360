package com.example.projectthree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<dbHandler> extends AppCompatActivity {
    TextView totalCostDollar, totalCostPercent;

    EditText grossSales;
    EditText descriptionRow1, descriptionRow2, descriptionRow3;
    EditText priceRow1, priceRow2, priceRow3;
    EditText startCountRow1, startCountRow2, startCountRow3;
    EditText endCountRow1, endCountRow2, endCountRow3;

    Button save,signOut, calculate;

    // Get permission to send sms, was also added to MANIFEST
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0;

    private DBHandler dbHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiates SQLite
        dbHandler = new DBHandler(MainActivity.this);

        // Get permission to send sms but does not currently effect functionality
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS))
            {

            }
            else
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }

        // references to buttons and other controls on the layout

        TextView totalCostDollar = findViewById(R.id.totalCostDollar);
        TextView totalCostPercent = findViewById(R.id.totalCostPercent);

        EditText grossSales = findViewById(R.id.grossSales);

        EditText descriptionRow1 = findViewById(R.id.descriptionRow1);
        EditText descriptionRow2 = findViewById(R.id.descriptionRow2);
        EditText descriptionRow3 = findViewById(R.id.descriptionRow3);

        EditText priceRow1 = findViewById(R.id.priceRow1);
        EditText priceRow2 = findViewById(R.id.priceRow2);
        EditText priceRow3 = findViewById(R.id.priceRow3);

        EditText startCountRow1 = findViewById(R.id.startCountRow1);
        EditText startCountRow2 = findViewById(R.id.startCountRow2);
        EditText startCountRow3 = findViewById(R.id.startCountRow3);

        EditText endCountRow1 = findViewById(R.id.endCountRow1);
        EditText endCountRow2 = findViewById(R.id.endCountRow2);
        EditText endCountRow3 = findViewById(R.id.endCountRow3);

        Button save = findViewById(R.id.save);
        Button signOut = findViewById(R.id.signOut);
        Button calculate = findViewById(R.id.calculate);

        // button listeners for the save, calculate, and sign-out


        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            // values to set
                double tCD, tCP;

            // values to get
                double pR1, pR2, pR3, sR1, sR2, sR3, eR1, eR2, eR3, gS;


                try {
                    String pR1Str = priceRow1.getText().toString();
                    pR1 = Double.parseDouble(pR1Str);
                }
                catch (NumberFormatException ex) {
                    pR1 = 0;
                }

                try {
                    String pR2Str = priceRow2.getText().toString();
                    pR2 = Double.parseDouble(pR2Str);
                }
                catch (NumberFormatException ex) {
                    pR2 = 0;
                }

                try {
                    String pR3Str = priceRow3.getText().toString();
                    pR3 = Double.parseDouble(pR3Str);
                }
                catch (NumberFormatException ex) {
                    pR3 = 0;
                }

                try {
                    String sR1Str = startCountRow1.getText().toString();
                    sR1 = Double.parseDouble(sR1Str);
                }
                catch (NumberFormatException ex) {
                    sR1 = 0;
                }

                try {
                    String sR2Str = startCountRow2.getText().toString();
                    sR2 = Double.parseDouble(sR2Str);
                }
                catch (NumberFormatException ex) {
                    sR2 = 0;
                }

                try {
                    String sR3Str = startCountRow3.getText().toString();
                    sR3 = Double.parseDouble(sR3Str);
                }
                catch (NumberFormatException ex) {
                    sR3 = 0;
                }
                try {
                    String eR1Str = endCountRow1.getText().toString();
                    eR1 = Double.parseDouble(eR1Str);
                }
                catch (NumberFormatException ex) {
                    eR1 = 0;
                }

                try {
                    String eR2Str = endCountRow2.getText().toString();
                    eR2 = Double.parseDouble(eR2Str);
                }
                catch (NumberFormatException ex) {
                    eR2 = 0;
                }

                try {
                    String eR3Str = endCountRow3.getText().toString();
                    eR3 = Double.parseDouble(eR3Str);
                }
                catch (NumberFormatException ex) {
                    eR3 = 0;
                }

                try {
                    String gStr = grossSales.getText().toString();
                    gS = Double.parseDouble(gStr);
                }
                catch (NumberFormatException ex) {
                    gS = 0;
                }

                tCD = (((sR1 - eR1) * pR1) + ((sR2 - eR2) * pR2) + ((sR3 - eR3) * pR3));
                tCP = tCD/gS*100;

                totalCostDollar.setText(String.format("%.2f", tCD));
                totalCostPercent.setText(String.format("%.2f", tCP));
        }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//TODO
                // variables that we need to get: double pR1, pR2, pR3, sR1, sR2, sR3, eR1, eR2, eR3, gS;

                // below line is to get data from all edit text fields.
                String description1 = descriptionRow1.getText().toString();
                String price1 = priceRow1.getText().toString();
                String startCount1 = startCountRow1.getText().toString();
                String endCount1 = endCountRow1.getText().toString();

                // validating if the text fields are empty or not.
                if (description1.isEmpty() && price1.isEmpty() && startCount1.isEmpty() && endCount1.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewRow(description1, price1, startCount1, endCount1);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Save Successful.", Toast.LENGTH_SHORT).show();























            }
        });




    }
}