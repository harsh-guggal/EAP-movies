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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {


    private TextView signin;
    private EditText signinfirstname,signinlastname,signinemail,signinnumber,signinusername,signinpassword;
    private FirebaseAuth auth;
    private Button signinBtn;
    private ProgressBar signupprogressbar;

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
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();

        signin = findViewById(R.id.signin);
        signinfirstname = findViewById(R.id.signinfirstname);
        signinlastname = findViewById(R.id.signinlastname);
        signinemail = findViewById(R.id.signinemail);
        signinnumber = findViewById(R.id.signinnumber);
        signinusername = findViewById(R.id.signinusername);
        signinpassword = findViewById(R.id.signinpassword);
        auth = FirebaseAuth.getInstance();
        signinBtn = findViewById(R.id.signinbtn);
        signupprogressbar = findViewById(R.id.signupprogressbar);


        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupprogressbar.setVisibility(View.VISIBLE);
                
                String ufirstname,ulastname,uUsername,unumber,uemail,upassowrd;
                
                ufirstname = signinfirstname.getText().toString();
                ulastname = signinlastname.getText().toString();
                uUsername = signinusername.getText().toString();
                unumber = signinnumber.getText().toString();
                uemail = signinemail.getText().toString();
                upassowrd = signinpassword.getText().toString();

                
                if(!uemail.isEmpty() && !upassowrd.isEmpty())
                {
                    
                    Boolean passwordvalid = isValidPassword(upassowrd);
                    
                    if(passwordvalid)
                    {
                        auth.createUserWithEmailAndPassword(uemail,upassowrd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    signupprogressbar.setVisibility(View.INVISIBLE);
                                    startActivity(new Intent(getApplicationContext(),LogIn.class));
                                }
                                else
                                {
                                    signupprogressbar.setVisibility(View.INVISIBLE);
                                    Toast.makeText(getApplicationContext(), task.getException().getMessage().toString(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                    else
                    {
                        signupprogressbar.setVisibility(View.INVISIBLE);
                        Toast.makeText(getApplicationContext(), "Password must be strong!!", Toast.LENGTH_SHORT).show();
                    }
                    
                }
                else
                {
                    signupprogressbar.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "Please enter email and password", Toast.LENGTH_SHORT).show();
                }
            }
        });

//      to go to login page
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LogIn.class));
            }
        });


    }
    public boolean isValidPassword(String password)
    {
        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);

        // Return if the password
        // matched the ReGex
        return m.matches();
    }
}