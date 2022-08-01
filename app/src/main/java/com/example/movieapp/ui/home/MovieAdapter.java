package com.example.movieapp.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.movieapp.Models.MovieModel;
import com.example.movieapp.R;
import com.example.movieapp.movieDetails;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.RecyclerViewHolder>{

    private ArrayList<MovieModel> courseDataArrayList;
    private Context mcontext;

    public MovieAdapter(ArrayList<MovieModel> recyclerDataArrayList, Context mcontext) {
        this.courseDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item1, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder,int position) {
        // Set the data to textview and imageview.
        MovieModel recyclerData = courseDataArrayList.get(position);
        holder.moviename.setText(recyclerData.getCourse_name());
        holder.movieImage.setImageResource(recyclerData.getImgid());
//        holder.movieImage.setImageURI(Uri.parse(recyclerData.getImgid()));





//        holder.moviesClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(mcontext.getApplicationContext(), "Position "+position, Toast.LENGTH_SHORT).show();
//                String mname = holder.moviename.toString();
//                Intent i = new Intent(v.getContext(),movieDetails.class);
//
////                i.putExtra("moviename",mname);
//                Toast.makeText(mcontext.getApplicationContext(), mname, Toast.LENGTH_SHORT).show();
//
//                mcontext.startActivity(i);
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return courseDataArrayList.size();
    }



    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView moviename;
        private ImageView movieImage;
        private Button moviesClick;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            moviename = itemView.findViewById(R.id.movieName);
            movieImage = itemView.findViewById(R.id.movieImage);
            moviesClick = itemView.findViewById(R.id.button);

//            BitmapDrawable drawable = (BitmapDrawable) movieImage.getDrawable();
//            Bitmap bitmap = drawable.getBitmap();
//            final byte[] arr = bitmap.getNinePatchChunk();


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent i = new Intent(mcontext.getApplicationContext(), movieDetails.class);
                    String mname = moviename.getText().toString();


                    i.putExtra("mname",mname);
//                        i.putExtra("image",arr);



                    mcontext.startActivity(i);

                }
            });





        }
    }
}