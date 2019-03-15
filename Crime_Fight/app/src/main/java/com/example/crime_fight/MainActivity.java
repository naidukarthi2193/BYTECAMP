package com.example.crime_fight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.crime_fight.Activities.Police_Home;
import com.example.crime_fight.Activities.Victim_Home;

public class MainActivity extends AppCompatActivity {

    private Button victim_login_button;
    private Button police_Login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        victim_login_button=(Button)findViewById(R.id.victim_button);
        police_Login_button=(Button)findViewById(R.id.police_button);

        final Intent intentvictim = new Intent(getBaseContext(), Victim_Home.class);
        final Intent intentpolice = new Intent(getBaseContext(), Police_Home.class);

        victim_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentvictim);
            }
        });

        police_Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentpolice);
            }
        });





    }
}
