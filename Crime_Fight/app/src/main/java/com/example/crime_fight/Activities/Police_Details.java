package com.example.crime_fight.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.crime_fight.Adapters.ComplainAdapter;
import com.example.crime_fight.Adapters.PoliceAdapter;
import com.example.crime_fight.Models.ComplainModel;
import com.example.crime_fight.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class Police_Details extends AppCompatActivity {

    private String Police;

    private RecyclerView police_Recycler;
    private PoliceAdapter police_recycler_adapter;

    private ArrayList<ComplainModel> policelist;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police__details);

        Intent getIntent = getIntent();
        Police = getIntent.getStringExtra("POLICE");

        FirebaseApp.initializeApp(this);
        police_Recycler =(RecyclerView) findViewById(R.id.police_Recycler);
        LinearLayoutManager layoutmanage  = new LinearLayoutManager(this);
        layoutmanage.setOrientation(LinearLayoutManager.VERTICAL);
        police_Recycler.setLayoutManager(layoutmanage);
        policelist = new ArrayList<ComplainModel>();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Police").child(Police).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                policelist.clear();
                for (DataSnapshot uniquesnapshot : dataSnapshot.getChildren()){
//                        Log.d("DetailActivity ", "Food Type " + uniquesnapshot.getValue(HotelModel.class).getName());
                    policelist.add(uniquesnapshot.getValue(ComplainModel.class));
                }

                Log.d(TAG, "onDataChange: siiize " + policelist.size());
                police_recycler_adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        police_recycler_adapter = new PoliceAdapter(getBaseContext(),policelist);
        police_Recycler.setAdapter(police_recycler_adapter);












    }
}
