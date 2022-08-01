package com.example.movieapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.movieapp.Models.TheaterModel2;

import java.util.ArrayList;

public class TheaterAdapter2 extends RecyclerView.Adapter<TheaterAdapter2.RecyclerViewHolder>{

    private ArrayList<TheaterModel2> courseDataArrayList;
    private Context mcontext;
    int index = -1;

    public TheaterAdapter2(ArrayList<TheaterModel2> recyclerDataArrayList, Context mcontext) {
        this.courseDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout7, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // Set the data to textview and imageview.
        TheaterModel2 recyclerData = courseDataArrayList.get(position);

//        holder.moviename.setText(recyclerData.getCourse_name());
//        holder.movieImage.setImageResource(recyclerData.getImgid());

        holder.theaterlocation.setText(recyclerData.getTheaterLocation());
        holder.theatername.setText(recyclerData.getTheaterName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                index = position;
                notifyDataSetChanged();



            }
        });
        if(index == position)
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#FF5722"));
            holder.theatername.setTextColor(Color.parseColor("#ffffff"));
            holder.theaterlocation.setTextColor(Color.parseColor("#ffffff"));

        }
        else
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.theatername.setTextColor(Color.parseColor("#000000"));
            holder.theaterlocation.setTextColor(Color.parseColor("#000000"));

        }




    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return courseDataArrayList.size();
    }


    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView theatername,theaterlocation;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
//            moviename = itemView.findViewById(R.id.movieName);
//            movieImage = itemView.findViewById(R.id.movieImage);
//            moviesClick = itemView.findViewById(R.id.button);

            theaterlocation = itemView.findViewById(R.id.theaterLocation);
            theatername = itemView.findViewById(R.id.theatername);

        }
    }
}