package com.example.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity {

    private TextView signUp;
    private EditText loginemail,loginpassword;
    private Button loginbtn;
    private FirebaseAuth auth;
    private ProgressBar loginprogressBar;

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser != null)
        {
            startActivity(new Intent(getApplicationContext(), Home.class));
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        getSupportActionBar().hide();

        signUp = findViewById(R.id.signUp);
        loginbtn = findViewById(R.id.loginbtn);
        loginemail = findViewById(R.id.vEmail);
        loginpassword = findViewById(R.id.loginpassword);
        auth = FirebaseAuth.getInstance();
        loginprogressBar = findViewById(R.id.loginprogressBar);


//      to go to signUp page
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp.class));
            }
        });

        
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginprogressBar.setVisibility(View.VISIBLE);
                String uemail,upassword;
                
                uemail = loginemail.getText().toString();
                upassword = loginpassword.getText().toString();
                
                if(!uemail.isEmpty() && !upassword.isEmpty())
                {
                    auth.signInWithEmailAndPassword(uemail,upassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                loginprogressBar.setVisibility(View.INVISIBLE);
//                                Toast.makeText(getApplicationContext(), "Logged in successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),Home.class));
                                finish();
                            }
                            else
                            {
                                loginprogressBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(getApplicationContext(), task.getException().getMessage().toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else
                {
                    loginprogressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "Please enter Email and password", Toast.LENGTH_SHORT).show();
                }
                
                
            }
        });
        
        

    }
}