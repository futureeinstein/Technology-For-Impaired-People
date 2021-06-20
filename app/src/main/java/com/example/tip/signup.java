package com.example.tip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.tip.R.id.reg_email;
import static com.example.tip.R.id.reg_name;
import static com.example.tip.R.id.reg_password;
import static com.example.tip.R.id.reg_phoneno;
import static com.example.tip.R.id.reg_username;

public class signup extends AppCompatActivity {
    Button regBtn,regToLoginBtn;
    EditText regName,regUsername,regEmail,regPhoneNo,regPassword;

    FirebaseAuth firebaseAuth;


 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth =FirebaseAuth.getInstance();


        regName = findViewById(R.id.reg_name);
        regUsername=findViewById(R.id.reg_username);
        regEmail=findViewById(R.id.reg_email);
        regPhoneNo=findViewById(R.id.reg_phoneno);
        regPassword=findViewById(R.id.reg_password);
        regBtn=findViewById(R.id.reg_btn);
        regToLoginBtn=findViewById(R.id.reg_login_btn);


        if(firebaseAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),home.class));
            finish();
        }


        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = regEmail.getText().toString();
                String password = regPassword.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    regEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    regPassword.setError("Password is required");
                    return;
                }

                if (password.length()< 6) {
                    regPassword.setError("Password must be greater than six character");
                    return;
                }
                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signup.this, "User Created", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),home.class));
                        }
                        else {
                        Toast.makeText(signup.this, "Error!"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }


                    }
                });



            }
});


        regToLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),dashboard.class));
            }
        });
    }




    }
