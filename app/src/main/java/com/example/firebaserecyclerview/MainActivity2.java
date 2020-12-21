package com.example.firebaserecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {

    ImageView imageView;
    TextView Title,Des;
    String t,d,p;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.imgShow);
        Title = findViewById(R.id.titleID);
        Des = findViewById(R.id.desID);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("phone");
        String PhoneKey = getIntent().getStringExtra("phoneKey");
        databaseReference.child(PhoneKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String description = snapshot.child("description").getValue().toString();
                    String title = snapshot.child("title").getValue().toString();
                    String pic = snapshot.child("pic").getValue().toString();
                    Glide.with(MainActivity2.this).load(pic).into(imageView);
                    Title.setText(title);
                    Des.setText(description);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}