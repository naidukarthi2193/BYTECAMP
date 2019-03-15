package com.example.crime_fight.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.crime_fight.MainActivity;
import com.example.crime_fight.R;

public class Animation_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation__screen);
        ImageView text = (ImageView)findViewById(R.id.text);
        Animation anime  = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        text.startAnimation(anime);
        Runnable r = new Runnable() {

            @Override
            public void run() {
                // if you are redirecting from a fragment then use getActivity() as the context.
                startActivity(new Intent(Animation_Screen.this, MainActivity.class));

            }
        };


        Handler h = new Handler();
        // The Runnable will be executed after the given delay time
        h.postDelayed(r, 6000); // will be delayed for 1.5 seconds





    }

}
