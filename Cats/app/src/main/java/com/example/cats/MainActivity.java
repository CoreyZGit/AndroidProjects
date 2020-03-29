package com.example.cats;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public int catCounter = 1;
    ImageView image;
    MediaPlayer catMeow;

    public void switchCat(View view){

        Log.i("Cat Log", "Cat image has been switched");

       image = (ImageView) findViewById(R.id.catImage);
       catMeow = MediaPlayer.create(this, R.raw.meow);
       catMeow.start();

       switch(catCounter) {

           case 1:

               image.setImageResource(R.drawable.cat2);
               catCounter++;
               break;

           case 2:

               image.setImageResource(R.drawable.cat3);
               catCounter++;
               break;

           case 3:

               image.setImageResource(R.drawable.cat4);
               catCounter++;
               break;

           case 4:

               image.setImageResource(R.drawable.cat5);
               catCounter++;
               break;

           case 5:

               image.setImageResource(R.drawable.cat1);
               catCounter = 1;
               break;
       }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
