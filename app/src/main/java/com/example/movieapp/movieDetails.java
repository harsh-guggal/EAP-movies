package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class movieDetails extends AppCompatActivity {

    Button todateTime;
    TextView MovieName;
    ImageView MovieImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        Intent i = getIntent();
        MovieName = findViewById(R.id.MovieName);
        MovieImage = findViewById(R.id.MovieImage);

        String moviename = i.getStringExtra("mname");
        MovieName.setText(moviename);

//
//        byte[] arr = i.getByteArrayExtra("image");
//        Bitmap map = BitmapFactory.decodeByteArray(arr,0,arr.length);
//
//        MovieImage.setImageBitmap(map);


        if(moviename.equals("The Kashmir Files"))
        {
            MovieImage.setImageResource(R.drawable.fourth);
        }
        else if(moviename.equals("TARA MIRA"))
        {
            MovieImage.setImageResource(R.drawable.third);

        }
        else if(moviename.equals("Suryavanshi"))
        {
            MovieImage.setImageResource(R.drawable.second);

        }
        else
        {
            MovieImage.setImageResource(R.drawable.one);

        }



        getSupportActionBar().hide();
        todateTime = findViewById(R.id.todateTime);

        todateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),DateTimeSelection.class);

                String mname = (String) MovieName.getText();
                i.putExtra("mname",mname);


                startActivity(i);
            }
        });








    }
}