package com.example.movieapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.movieapp.Models.MovieModel;
import com.example.movieapp.R;
import com.example.movieapp.databinding.FragmentDashboardBinding;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    private GridView moviesGV;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        moviesGV = root.findViewById(R.id.UpComingGridView);

        ArrayList<MovieModel> movieModelArrayList = new ArrayList<MovieModel>();
        movieModelArrayList.add(new MovieModel("Aaja Mexico Challiye", R.drawable.one));
        movieModelArrayList.add(new MovieModel("Suryavanshi", R.drawable.second));
        movieModelArrayList.add(new MovieModel("Tara Mira", R.drawable.third));
        movieModelArrayList.add(new MovieModel("The Kashmir Files", R.drawable.fourth));
        movieModelArrayList.add(new MovieModel("Tara Mira", R.drawable.third));
        movieModelArrayList.add(new MovieModel("The Kashmir Files", R.drawable.fourth));
        UpcomingMovieAdapter adapter = new UpcomingMovieAdapter(getContext(), movieModelArrayList);
        moviesGV.setAdapter(adapter);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}