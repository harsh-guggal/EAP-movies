package com.example.movieapp.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.movieapp.Models.TheaterModel;
import com.example.movieapp.R;
import com.example.movieapp.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private GridView theaterGV;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        theaterGV = root.findViewById(R.id.theaterGridView);



        ArrayList<TheaterModel> theaterModelArrayList = new ArrayList<TheaterModel>();
        theaterModelArrayList.add(new TheaterModel("Savllo 3d - Wallatte","email@gmail.com","+91 1234567890","Khera, haryana", R.drawable.theater1));
        theaterModelArrayList.add(new TheaterModel("Savllo 3d - Wallatte","email@gmail.com","+91 1234567890","Khera, haryana", R.drawable.theater1));
        theaterModelArrayList.add(new TheaterModel("Savllo 3d - Wallatte","email@gmail.com","+91 1234567890","Khera, haryana", R.drawable.theater1));
        theaterModelArrayList.add(new TheaterModel("Savllo 3d - Wallatte","email@gmail.com","+91 1234567890","Khera, haryana", R.drawable.theater1));
        theaterModelArrayList.add(new TheaterModel("Savllo 3d - Wallatte","email@gmail.com","+91 1234567890","Khera, haryana", R.drawable.theater1));
        theaterModelArrayList.add(new TheaterModel("Savllo 3d - Wallatte","email@gmail.com","+91 1234567890","Khera, haryana", R.drawable.theater1));
        TheaterAdapter adapter = new TheaterAdapter(getContext(), theaterModelArrayList);
        theaterGV.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}