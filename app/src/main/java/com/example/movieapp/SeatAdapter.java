package com.example.movieapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SeatAdapter extends RecyclerView.Adapter<SeatAdapter.ViewHolder> {

    private String[] mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    int index = -1;

    // data is passed into the constructor
    SeatAdapter(Context context, String[] data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.card_layout9, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.seatno.setText(mData[position]);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                index = position;
//                notifyDataSetChanged();
                holder.itemView.setBackgroundColor(Color.parseColor("#FF5722"));
                holder.seatno.setTextColor(Color.parseColor("#ffffff"));



            }
        });

//        if(index == position)
//        {
//            holder.itemView.setBackgroundColor(Color.parseColor("#FF5722"));
//            holder.seatno.setTextColor(Color.parseColor("#ffffff"));
//
//        }
//        else
//        {
//            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
//            holder.seatno.setTextColor(Color.parseColor("#000000"));
//
//        }






    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.length;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView seatno;

        ViewHolder(View itemView) {
            super(itemView);
            seatno = itemView.findViewById(R.id.seatno);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData[id];
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}