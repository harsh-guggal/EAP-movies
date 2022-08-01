package com.example.movieapp.ui.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.movieapp.Models.NewsModel;
import com.example.movieapp.R;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<NewsModel> {
    public NewsAdapter(@NonNull Context context, ArrayList<NewsModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item4, parent, false);
        }


        NewsModel newsModel = getItem(position);

        TextView news_title,news_desc;
        Button read_more;
        ImageView news_image;

        news_title = listitemView.findViewById(R.id.news_title);
        news_desc = listitemView.findViewById(R.id.news_desc);
        read_more = listitemView.findViewById(R.id.read_more);
        news_image = listitemView.findViewById(R.id.news_image);

        news_title.setText(newsModel.getNews_title());
        news_desc.setText(newsModel.getNews_desc());
        news_image.setImageResource(newsModel.getImgId());

        return listitemView;
    }
}
