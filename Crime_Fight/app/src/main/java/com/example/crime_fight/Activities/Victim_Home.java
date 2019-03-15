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

public class Victim_Home extends AppCompatActivity {
    private FloatingActionButton filecomplain;
    private DatabaseReference reference;
    private RecyclerView victim_Recycler;
    private ComplainAdapter victim_recycler_adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ComplainModel> complainlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victim__home);
        FirebaseApp.initializeApp(this);
        reference= FirebaseDatabase.getInstance().getReference();
        victim_Recycler =(RecyclerView) findViewById(R.id.victim_recycler);
        layoutManager = new LinearLayoutManager(this);
        victim_Recycler.setLayoutManager(layoutManager);
        victim_recycler_adapter = new ComplainAdapter(getBaseContext(),complainlist);
        victim_Recycler.setAdapter(victim_recycler_adapter);

        complainlist = new ArrayList<ComplainModel>();
        complainlist.add(new ComplainModel("kar","kar","kar","kar","kar","kar"));

        reference.child("Complain").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue() != null){
                    Log.d("Firebase",dataSnapshot.getValue().toString());

                }

                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    complainlist.add(dataSnapshot1.getValue(ComplainModel.class));
                    Log.d("LIST",dataSnapshot1.getValue(ComplainModel.class).toString());
                }
                victim_recycler_adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getBaseContext(),"Error",Toast.LENGTH_LONG).show();
            }
        });

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
