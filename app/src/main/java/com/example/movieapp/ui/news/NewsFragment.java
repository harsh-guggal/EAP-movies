package com.example.movieapp.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.movieapp.Models.NewsModel;
import com.example.movieapp.R;
import com.example.movieapp.databinding.FragmentNewsBinding;

import java.util.ArrayList;

public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;
    private GridView newsGV;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        newsGV = root.findViewById(R.id.NewsGridView);

        ArrayList<NewsModel> newsModelArrayList = new ArrayList<NewsModel>();
        newsModelArrayList.add(new NewsModel(R.drawable.one,"Black Panther's review: A sleek Marvel of a singly superhero","black panther, colloquial term used to refer to large felines classified in the genus Panthera that are characterized by a coat of black fur or large concentrations of black spots set against a dark background."));
        newsModelArrayList.add(new NewsModel(R.drawable.second,"Black Panther's review: A sleek Marvel of a singly superhero","black panther, colloquial term used to refer to large felines classified in the genus Panthera that are characterized by a coat of black fur or large concentrations of black spots set against a dark background."));
        newsModelArrayList.add(new NewsModel(R.drawable.third,"Black Panther's review: A sleek Marvel of a singly superhero","black panther, colloquial term used to refer to large felines classified in the genus Panthera that are characterized by a coat of black fur or large concentrations of black spots set against a dark background."));
        newsModelArrayList.add(new NewsModel(R.drawable.fourth,"Black Panther's review: A sleek Marvel of a singly superhero","black panther, colloquial term used to refer to large felines classified in the genus Panthera that are characterized by a coat of black fur or large concentrations of black spots set against a dark background."));
        newsModelArrayList.add(new NewsModel(R.drawable.first,"Black Panther's review: A sleek Marvel of a singly superhero","black panther, colloquial term used to refer to large felines classified in the genus Panthera that are characterized by a coat of black fur or large concentrations of black spots set against a dark background."));

        NewsAdapter adapter = new NewsAdapter(getContext(), newsModelArrayList);
        newsGV.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
