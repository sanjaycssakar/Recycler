package com.example.deepa.recycler;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {
     private static final String TAG = "GalleryActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: method is Created");
        getincomingIntent();

    }

    private void getincomingIntent(){
        Log.d(TAG, "getIntent: Checking for incoming intents");
        if(getIntent().hasExtra("image_urls")&& getIntent().hasExtra("names")){
            Log.d(TAG, "getincomingIntent: found intent extra ");
             String imageUrls = getIntent().getStringExtra("image_urls");
            String names = getIntent().getStringExtra("names");
            setimagenames(imageUrls,names);
        }
    }

    private void setimagenames(String imageUrls,String names){
        Log.d(TAG, "setimagenames: started for detting images and names");
        TextView textView = findViewById(R.id.image_description);
        ImageView imageView = findViewById(R.id.image);
        textView.setText(names);
        Glide.with(this).asBitmap().load(imageUrls).into(imageView);
    }
}
