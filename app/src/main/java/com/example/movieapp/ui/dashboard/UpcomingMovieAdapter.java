package com.example.movieapp.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.movieapp.Models.MovieModel;
import com.example.movieapp.R;

import java.util.ArrayList;

public class UpcomingMovieAdapter extends ArrayAdapter<MovieModel> {
    public UpcomingMovieAdapter(@NonNull Context context, ArrayList<MovieModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item2, parent, false);
        }


        MovieModel courseModel = getItem(position);
        TextView moviename = listitemView.findViewById(R.id.movieName);
        ImageView movieimage = listitemView.findViewById(R.id.movieImage);
        moviename.setText(courseModel.getCourse_name());
        movieimage.setImageResource(courseModel.getImgid());
        return listitemView;
    }
}
