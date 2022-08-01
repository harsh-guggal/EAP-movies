package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SeatSelection extends AppCompatActivity {

    private RecyclerView seatRv;
    private String[] seatData = {"E1","E2","E3","E4","E5","E6","E7","E8","E9"
            ,"D1","D2","D3","D4","D5","D6","D7","D8","D9"
            ,"C1","C2","C3","C4","C5","C6","C7","C8","C9"
            ,"B1","B2","B3","B4","B5","B6","B7","B8","B9"
            ,"A1","A2","A3","A4","A5","A6","A7","A8","A9"};

    private Button toPayment;
    private TextView movieName2;
    private ImageView movieImage2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_selection);

        getSupportActionBar().hide();

        seatRv = findViewById(R.id.seatRV);
        toPayment = findViewById(R.id.toPayment);


        movieImage2 = findViewById(R.id.movieImage2);
        movieName2 = findViewById(R.id.movieName2);
        Intent i = getIntent();
        String moviename = i.getStringExtra("mname");
        movieName2.setText(moviename);
        if(moviename.equals("The Kashmir Files"))
        {
            movieImage2.setImageResource(R.drawable.fourth);
        }
        else if(moviename.equals("TARA MIRA"))
        {
            movieImage2.setImageResource(R.drawable.third);

        }
        else if(moviename.equals("Suryavanshi"))
        {
            movieImage2.setImageResource(R.drawable.second);

        }
        else
        {
            movieImage2.setImageResource(R.drawable.one);

        }



        SeatAdapter seatAdapter = new SeatAdapter(getApplicationContext(),seatData);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),9);

        seatRv.setLayoutManager(gridLayoutManager);
        seatRv.setAdapter(seatAdapter);


        toPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PaymentForm.class));
//                Toast.makeText(getApplicationContext(), "Sending To Payment Activity......", Toast.LENGTH_SHORT).show();
            }
        });

    }
}