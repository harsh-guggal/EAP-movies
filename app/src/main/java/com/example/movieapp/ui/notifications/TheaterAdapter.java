package com.example.movieapp.ui.notifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.movieapp.Models.TheaterModel;
import com.example.movieapp.R;

import java.util.ArrayList;

public class TheaterAdapter extends ArrayAdapter<TheaterModel> {
    public TheaterAdapter(@NonNull Context context, ArrayList<TheaterModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item3, parent, false);
        }


        TheaterModel theaterModel = getItem(position);
//        TextView moviename = listitemView.findViewById(R.id.movieName);
//        ImageView movieimage = listitemView.findViewById(R.id.movieImage);


//        moviename.setText(courseModel.getCourse_name());
//        movieimage.setImageResource(courseModel.getImgid());


        TextView theaterName,theaterLocation,theaterContactNumber,theaterEmail;
        ImageView theaterImage;


        theaterName = listitemView.findViewById(R.id.news_title);
        theaterLocation = listitemView.findViewById(R.id.theaterLocation);
        theaterContactNumber = listitemView.findViewById(R.id.theaterContactNumber);
        theaterEmail = listitemView.findViewById(R.id.theaterEmail);
        theaterImage = listitemView.findViewById(R.id.news_image);

        theaterName.setText(theaterModel.getTheater_name());
        theaterLocation.setText(theaterModel.getTheater_location());
        theaterEmail.setText(theaterModel.getTheater_email());
        theaterContactNumber.setText(theaterModel.getTheater_number());
        theaterImage.setImageResource(theaterModel.getImgid());


        return listitemView;
    }
}
