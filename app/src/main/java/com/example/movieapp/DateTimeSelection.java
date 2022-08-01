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


import com.example.movieapp.Models.DateModel;

import java.util.ArrayList;

public class DateTimeSelection extends AppCompatActivity {

    private RecyclerView dateRV,timeRV;
    private ArrayList<DateModel> dateModelArrayList;
    private String[] timedata = {"10:30 AM","01:30 PM","04:15 PM","07:00 PM","10:00 PM"};
    private Button toTheaterSelection;
    private TextView movieName2;
    private ImageView movieImage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_selection);

        getSupportActionBar().hide();



        dateRV=findViewById(R.id.dateRV);
        timeRV = findViewById(R.id.timeRV);

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



        toTheaterSelection = findViewById(R.id.toTheaterSelection);

        // created new array list..
        dateModelArrayList=new ArrayList<>();

        // added data to array list
        dateModelArrayList.add(new DateModel("09","FRIDAY","MAR"));
        dateModelArrayList.add(new DateModel("10","FRIDAY","MAR"));
        dateModelArrayList.add(new DateModel("11","FRIDAY","MAR"));
        dateModelArrayList.add(new DateModel("12","FRIDAY","MAR"));
        dateModelArrayList.add(new DateModel("13","FRIDAY","MAR"));
        dateModelArrayList.add(new DateModel("14","FRIDAY","MAR"));
        dateModelArrayList.add(new DateModel("15","FRIDAY","MAR"));
        dateModelArrayList.add(new DateModel("16","FRIDAY","MAR"));
        // added data from arraylist to adapter class.
        DateAdapter adapter=new DateAdapter(dateModelArrayList,getApplicationContext());

        // setting grid layout manager to implement grid view.
        // in this method '4' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),4);

        // at last set adapter to recycler view.
        dateRV.setLayoutManager(layoutManager);
        dateRV.setAdapter(adapter);



        TimeAdapter timeAdapter = new TimeAdapter(getApplicationContext(),timedata);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);

        timeRV.setLayoutManager(gridLayoutManager);
        timeRV.setAdapter(timeAdapter);


        toTheaterSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),TheaterSelection.class);

                i.putExtra("mname",moviename);

                startActivity(i);
            }
        });


    }
//    public void clicked()
//    {
//        Toast.makeText(DateTimeSelection.this, "Clicked", Toast.LENGTH_SHORT).show();
//    }
}