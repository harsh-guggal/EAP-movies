package com.example.movieapp.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.movieapp.EmailVerification;
import com.example.movieapp.LogIn;
import com.example.movieapp.R;
import com.example.movieapp.databinding.FragmentSettingsBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingFragment extends Fragment {

    private FragmentSettingsBinding binding;
    private LinearLayout logout,emailverification;
    private FirebaseAuth auth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        logout = root.findViewById(R.id.logout);
        emailverification = root.findViewById(R.id.emailVerification);
        auth = FirebaseAuth.getInstance();
        
        
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "logout clickecd", Toast.LENGTH_SHORT).show();

                auth.signOut();
                startActivity(new Intent(getContext(), LogIn.class));
            }
        });

        emailverification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), EmailVerification.class));
            }
        });


        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

/*
        String email = currentUser.getEmail();
        Toast.makeText(getContext(), email, Toast.LENGTH_SHORT).show();
*/


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}
