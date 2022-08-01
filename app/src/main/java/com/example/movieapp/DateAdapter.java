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


import com.example.movieapp.Models.DateModel;

import java.util.ArrayList;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.RecyclerViewHolder>{

    private ArrayList<DateModel> courseDataArrayList;
    private Context mcontext;
    int index = -1;

    public DateAdapter(ArrayList<DateModel> recyclerDataArrayList, Context mcontext) {
        this.courseDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout5, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // Set the data to textview and imageview.
        DateModel recyclerData = courseDataArrayList.get(position);

//        holder.moviename.setText(recyclerData.getCourse_name());
//        holder.movieImage.setImageResource(recyclerData.getImgid());

        holder.date.setText(recyclerData.getDate());
        holder.day.setText(recyclerData.getDay());
        holder.month.setText(recyclerData.getMonth());

//
//        holder.moviesClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(mcontext.getApplicationContext(), "Position "+position, Toast.LENGTH_SHORT).show();
//
//                Intent i = new Intent(v.getContext(),movieDetails.class);
//                mcontext.startActivity(i);
//
//            }
//        });

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
            holder.date.setTextColor(Color.parseColor("#ffffff"));
            holder.day.setTextColor(Color.parseColor("#ffffff"));
            holder.month.setTextColor(Color.parseColor("#ffffff"));

        }
        else
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.date.setTextColor(Color.parseColor("#000000"));
            holder.day.setTextColor(Color.parseColor("#000000"));
            holder.month.setTextColor(Color.parseColor("#000000"));

        }




    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return courseDataArrayList.size();
    }


    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView day,date,month;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
//            moviename = itemView.findViewById(R.id.movieName);
//            movieImage = itemView.findViewById(R.id.movieImage);
//            moviesClick = itemView.findViewById(R.id.button);

            day = itemView.findViewById(R.id.day);
            date = itemView.findViewById(R.id.date);
            month = itemView.findViewById(R.id.month);

        }
    }
}