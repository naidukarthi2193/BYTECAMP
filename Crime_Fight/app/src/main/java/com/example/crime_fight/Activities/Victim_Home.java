package com.example.crime_fight.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.crime_fight.Adapters.ComplainAdapter;
import com.example.crime_fight.Fragments.Add_Complain;
import com.example.crime_fight.Models.ComplainModel;
import com.example.crime_fight.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class Victim_Home extends AppCompatActivity {
    private FloatingActionButton filecomplain;

    private RecyclerView victim_Recycler;
    private ComplainAdapter victim_recycler_adapter;

    private ArrayList<ComplainModel> complainlist;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victim__home);
        FirebaseApp.initializeApp(this);
        victim_Recycler =(RecyclerView) findViewById(R.id.victim_recycler);
        LinearLayoutManager layoutmanage  = new LinearLayoutManager(this);
        layoutmanage.setOrientation(LinearLayoutManager.VERTICAL);
        victim_Recycler.setLayoutManager(layoutmanage);
        complainlist = new ArrayList<ComplainModel>();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Complain").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                complainlist.clear();
                for (DataSnapshot uniquesnapshot : dataSnapshot.getChildren()){
                    complainlist.add(uniquesnapshot.getValue(ComplainModel.class));

                }

                Log.d(TAG, "onDataChange: size " + complainlist.size());
                victim_recycler_adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        victim_recycler_adapter = new ComplainAdapter(getBaseContext(),complainlist);
        victim_Recycler.setAdapter(victim_recycler_adapter);

        filecomplain=(FloatingActionButton)findViewById(R.id.complain_file);
        filecomplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Add_Complain bottomsheet = new Add_Complain();
                bottomsheet.show(getSupportFragmentManager(),"ExampleBottomSheet");

            }
        });

    }



}
