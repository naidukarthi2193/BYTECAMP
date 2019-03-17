package com.example.crime_fight.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.crime_fight.R;
import com.google.firebase.database.DataSnapshot;

public class Police_Home extends AppCompatActivity {
    private CardView cardDombivili,cardThane,cardNerul,cardMumbai,cardNavi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police__home);
        final   Intent detailsintent = new Intent(getBaseContext(),Police_Details.class);

        cardDombivili= (CardView)findViewById(R.id.dombiviliCard);
        cardMumbai=(CardView)findViewById(R.id.mumbaiCard);
        cardThane=(CardView)findViewById(R.id.thaneCard);
        cardNerul=(CardView)findViewById(R.id.nerulCard);
        cardNavi=(CardView)findViewById(R.id.navimumbaiCard);

        cardDombivili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsintent.putExtra("POLICE","Dombivili");
                startActivity(detailsintent);
            }
        });

        cardNavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsintent.putExtra("POLICE","Navi Mumbai");
                startActivity(detailsintent);
            }
        });

        cardNerul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsintent.putExtra("POLICE","Nerul");
                startActivity(detailsintent);
            }
        });

        cardThane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsintent.putExtra("POLICE","Thane");
                startActivity(detailsintent);
            }
        });

        cardMumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsintent.putExtra("POLICE","Mumbai");
                startActivity(detailsintent);
            }
        });









    }
}
