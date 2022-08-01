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

public class howManyTickets extends AppCompatActivity {


    private RecyclerView ticketRV;
    private String[] data = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
    private Button toSeatSelection;
    private TextView movieName2;
    private ImageView movieImage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_many_tickets);

        getSupportActionBar().hide();


        ticketRV = findViewById(R.id.ticketRV);
        toSeatSelection = findViewById(R.id.toSeatSelection);

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


        TicketAdapter timeAdapter = new TicketAdapter(getApplicationContext(),data);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);

        ticketRV.setLayoutManager(gridLayoutManager);
        ticketRV.setAdapter(timeAdapter);


        toSeatSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),SeatSelection.class);

                i.putExtra("mname",moviename);

                startActivity(i);
            }
        });


    }
}