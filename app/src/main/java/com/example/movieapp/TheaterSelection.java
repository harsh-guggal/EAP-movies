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


import com.example.movieapp.Models.TheaterModel2;

import java.util.ArrayList;

public class TheaterSelection extends AppCompatActivity {

    private RecyclerView theaterRV;
    private ArrayList<TheaterModel2> theaterList;
    Button toTickets;
    private TextView movieName2;
    private ImageView movieImage2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater_selection);


        getSupportActionBar().hide();

        theaterRV = findViewById(R.id.theaterRV);
        toTickets = findViewById(R.id.toTickets);

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







        theaterList = new ArrayList<>();


        theaterList.add(new TheaterModel2("Savoy 3D","Haryana"));
        theaterList.add(new TheaterModel2("Savoy 2","Punjab"));
        theaterList.add(new TheaterModel2("Cinemax 3D","Mumbai"));
        theaterList.add(new TheaterModel2("Queens 3D","Haryana"));
        theaterList.add(new TheaterModel2("Jothi 3D","Kerala"));
        theaterList.add(new TheaterModel2("Willimax 3D","Jharkhand"));


        TheaterAdapter2 theaterAdapter = new TheaterAdapter2(theaterList,getApplicationContext());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);

        theaterRV.setLayoutManager(gridLayoutManager);
        theaterRV.setAdapter(theaterAdapter);



        toTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),howManyTickets.class);

                i.putExtra("mname",moviename);

                startActivity(i);
            }
        });


    }
}