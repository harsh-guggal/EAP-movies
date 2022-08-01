package com.example.movieapp.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.movieapp.Models.MovieModel;
import com.example.movieapp.R;
import com.example.movieapp.databinding.FragmentHomeBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private RecyclerView moviesRV;
    private ArrayList<MovieModel> recyclerDataArrayList;

//    private FirebaseAuth auth;
//    private Query query;
//    private FirebaseFirestore firestore;
//    private ListenerRegistration listenerRegistration;
//    private ArrayList<MovieModel> list;
//    private MovieAdapter movieAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        moviesRV=root.findViewById(R.id.moviesRV);
        recyclerDataArrayList=new ArrayList<>();


//        String[] movie = new String[2];
//        documentReference = db.collection("The Kashmir Files").document("Basic");
//        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if(task.isSuccessful())
//                {
////                    recyclerDataArrayList.add(new MovieModel(task.getResult().getString("movie_name"),task.getResult().getString("movieImage")));
//                    movie[1] = task.getResult().getString("movieImage");
//                    movie[0] = task.getResult().getString("movie_name");
//
//                    MovieModel m = task.getResult().toObject(MovieModel.class);
//
//                    recyclerDataArrayList.add(m);
//
//                }
//                else
//                {
//                    Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        // created new array list..

        // added data to array list
//        recyclerDataArrayList.add(new MovieModel(movie[0],movie[1]));
        recyclerDataArrayList.add(new MovieModel("TARA MIRA",R.drawable.third));
        recyclerDataArrayList.add(new MovieModel("Suryavanshi",R.drawable.second));
        recyclerDataArrayList.add(new MovieModel("The Kashmir Files",R.drawable.fourth));
        recyclerDataArrayList.add(new MovieModel("Aaja Mexico Chaliye",R.drawable.one));
        recyclerDataArrayList.add(new MovieModel("The Kashmir Files",R.drawable.fourth));
        recyclerDataArrayList.add(new MovieModel("Aaja Mexico Chaliye",R.drawable.one));




        // added data from arraylist to adapter class.
        MovieAdapter adapter=new MovieAdapter(recyclerDataArrayList,getContext());

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);

        // at last set adapter to recycler view.
        moviesRV.setLayoutManager(layoutManager);
        moviesRV.setAdapter(adapter);




        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}