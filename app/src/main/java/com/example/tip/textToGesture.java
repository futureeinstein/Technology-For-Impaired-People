package com.example.tip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.IOException;

public class textToGesture extends AppCompatActivity {
    FirebaseStorage storage=FirebaseStorage.getInstance();
    private StorageReference nStorageReference;
    EditText text_ttog ;
    ImageView lefticon;
    Button btn;
    ImageView img_ttog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_gesture);
        text_ttog = findViewById(R.id.ttog_text);
        lefticon=findViewById(R.id.left_icon);
        btn= findViewById(R.id.login_btn_dash);
        img_ttog = findViewById(R.id.image_ttog);
        //text to gesture connection start
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });

        //text to gesture connect end

        //status bar

        lefticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),home.class));
                finish();
            }
        });
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),dashboard.class));
        finish();
    }
  //getData() function definition for database connection


    private void getData() {

        String value = text_ttog.getText().toString().trim();

        if (value.equals("")) {
            Toast.makeText(this, "Please Enter Data Value", Toast.LENGTH_LONG).show();
            return;
        }
        else if (value.equals("hello" )) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fhellosign.jpg?alt=media&token=40b4f9d5-f0b0-4f05-90cd-9cb942e79bb";
            Picasso.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("goodbye")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fgoodbye.jpg?alt=media&token=e5adfe72-c547-40de-acf4-fea0c0000426";
            Picasso.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("thank you")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fthankyou.jpg?alt=media&token=4ae5445d-b5c2-4b3a-a113-507703ce67bf";
            Picasso.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("please")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fplease.jpg?alt=media&token=2f9684b2-d6d5-42ff-87e8-1acc0cce206b";
            Picasso.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("no")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fno.jpg?alt=media&token=bf692796-3fcf-41be-973c-b40cb5225e44";
            Picasso.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("yes")) {
            String uri ="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fyes.jpg?alt=media&token=bbc32165-9eed-4d4f-b8bb-6c5b9ad626d6";
            Picasso.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("how are you")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fhowareyoudoing.gif?alt=media&token=b068c386-50e1-402c-be15-dadc27ca533d";
            Glide.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("are you ok")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fareyouok.gif?alt=media&token=c21409d4-d69d-402c-913d-745df4f7fce8";
            Glide.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("awesome")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fawesome.gif?alt=media&token=52e75834-f3c4-4aa9-aef5-bca091777061";
            Glide.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("bye")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fbye.gif?alt=media&token=380dd8c0-872f-4639-9e57-aff6f321f229";
            Glide.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("cool")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fcool.gif?alt=media&token=f27e03e1-883c-4b26-b322-e46f363fed8d";
            Glide.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("good morning")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fgm.gif?alt=media&token=5bf561ec-9e08-4a7f-a993-68c93a0a2580";
            Glide.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("hey want to practice sign language")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fheywanttopracticemysignlanguage.gif?alt=media&token=3a5fbfe3-60e3-4d7f-b182-d4768cc05f20";
            Glide.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("how are you doing")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fhowareyou.gif?alt=media&token=9314b959-d2a0-459e-8c8a-caa619fa2132";
            Glide.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("how was you day")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fhowsyouday.gif?alt=media&token=608acec0-658f-4867-8f2e-abb5627fb276";
            Glide.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("i am fine")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fmfine.gif?alt=media&token=74e97070-8bb5-4d00-90c1-ba93eb4139c2";
            Glide.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("nice to meet you")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fnicetomeetyou.gif?alt=media&token=5a18bae3-4600-498e-b3bb-866f36015292";
            Glide.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("thirsty")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fthirsty.gif?alt=media&token=9723b5fb-0bb7-459c-83ca-c2e9be261b37";
            Glide.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("what are you doing")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fwhatareyoudoing.gif?alt=media&token=86e6757c-45d3-4294-a8e9-33e93d517250";
            Glide.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("where is the building")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fwherethebuilding.gif?alt=media&token=fea5a339-d185-4a6f-b35c-cbdf6b75b3c7";
            Glide.with(this).load(uri).into(img_ttog);
        }
        else if (value.equals("where is the classroom")) {
            String uri="https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fwheretheclassroom.gif?alt=media&token=e7f0b7d8-024e-4466-bc5a-39fb9ba3f3cd";
            Glide.with(this).load(uri).into(img_ttog);
        }

       else  if (value.equals("sign")) {
            String uri = "https://firebasestorage.googleapis.com/v0/b/tipapplication-5e879.appspot.com/o/pictures%2Fsigns.png?alt=media&token=3832e250-0eca-40b0-9fb2-35975bc0fb21";
            Picasso.with(this).load(uri).into(img_ttog);

        }
       else {
            Toast.makeText(this, "Sorry! not available right now", Toast.LENGTH_LONG).show();
            return;
        }



    }


}