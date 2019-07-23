package com.myapplicationdev.android.p11mydatabook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class AboutActivity extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        iv = findViewById(R.id.iv);
        String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";
        Picasso.with(this).load(imageUrl).placeholder(R.drawable.ajax_loader).error(R.drawable.error).into(iv, new Callback() {
            @Override
            public void onSuccess() {
                Toast.makeText(AboutActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError() {
                Toast.makeText(getApplicationContext(), "An error occurred", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
