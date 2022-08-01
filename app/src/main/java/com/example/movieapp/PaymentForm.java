package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_form);


        getSupportActionBar().hide();


        Button sendemail,backTomain;
        sendemail = findViewById(R.id.sendemail);
        backTomain = findViewById(R.id.backToseatSelection);

        sendemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                            String email = "lakshay8519125@jmieti.edu.in",
                                    subject = "Confirmation of booked Movie Ticket",
                                    message = "Hello,\nWe are happy to let you know that we have booked your movie ticket\n Enjoy your movie.\nIf you have any questions, contact us here or call us on 9813433176!\nWe are here to help!";

                            SendMail sm = new SendMail(getApplicationContext(), email, subject, message);

                            sm.execute();


                startActivity(new Intent(getApplicationContext(),paymentSuccessful.class));

            }
        });

        backTomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Home.class));
                finish();
            }
        });



    }
}