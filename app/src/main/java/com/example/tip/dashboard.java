package com.example.tip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

/**
 * For login screen
 */
public class dashboard extends AppCompatActivity {
    Button callSignup,callLogin;
    EditText memail,mpassword;
    FirebaseAuth firebaseAuth;


    /**
     * manage all login information
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        memail=findViewById(R.id.username);
        mpassword=findViewById(R.id.password);
        callSignup = findViewById(R.id.signup_screen);
        callLogin= findViewById(R.id.login_btn_dash);
        firebaseAuth=FirebaseAuth.getInstance();

/**
 * Firebase connection and validation
 * 
 */
        callLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = memail.getText().toString();
                String password = mpassword.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    memail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mpassword.setError("Password is required");
                    return;
                }

                if (password.length() < 6) {
                    mpassword.setError("Password must be greater than six character");
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(dashboard.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),home.class));
                        }
                        else {
                            Toast.makeText(dashboard.this, "Error!"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }

                    }
                });

            }   });

        callSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),signup.class));
            }
        });
    }
}