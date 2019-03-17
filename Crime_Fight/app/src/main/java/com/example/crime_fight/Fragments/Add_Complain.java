package com.example.crime_fight.Fragments;

import android.R.layout;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;


import com.example.crime_fight.Activities.Victim_Home;
import com.example.crime_fight.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.*;


public class Add_Complain extends BottomSheetDialogFragment implements OnItemSelectedListener{
    private ImageView close;
    private Button submit_but;
    private EditText name_edit;
    private EditText address_edit;
    private EditText complain_edit;
    private EditText adhar_edit;
    private Spinner police_spinner;
    private String police_option;
    FirebaseDatabase database;
    DatabaseReference myref;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_complain_fragment,container,false);
//        BottomSheetDialog dialog = new BottomSheetDialog(this,R.style.BottomSheetDialog);


        name_edit=(EditText)view.findViewById(R.id.editName);
        address_edit=(EditText)view.findViewById(R.id.editAddress);
        complain_edit=(EditText)view.findViewById(R.id.complainedit);
        adhar_edit = (EditText)view.findViewById(R.id.editadhar);
        police_spinner= (Spinner)view.findViewById(R.id.police_spinner);
        close=(ImageView)view.findViewById(R.id.closeButton);
        submit_but=(Button)view.findViewById(R.id.submitButton);

        police_spinner.setOnItemSelectedListener(this);
        List<String> stations = new ArrayList<String>();
        stations.add("Thane");
        stations.add("Dombivili");
        stations.add("Nerul");
        stations.add("Mumbai");
        stations.add("Navi Mumbai");

        ArrayAdapter<String> policeAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item,stations);
        policeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        police_spinner.setAdapter(policeAdapter);



        database = FirebaseDatabase.getInstance();
        myref = database.getReference("Complain");
         final Intent closeFrag = new Intent(getContext(), Victim_Home.class);



        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(closeFrag);

            }
        });

        submit_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myref =  FirebaseDatabase.getInstance().getReference();
                myref.child("Complain").child(name_edit.getText().toString()).child("name").setValue(name_edit.getText().toString());
                myref.child("Complain").child(name_edit.getText().toString()).child("address").setValue(address_edit.getText().toString());
                myref.child("Complain").child(name_edit.getText().toString()).child("complain").setValue(complain_edit.getText().toString());
                myref.child("Complain").child(name_edit.getText().toString()).child("adharnumber").setValue(adhar_edit.getText().toString());
                myref.child("Complain").child(name_edit.getText().toString()).child("policeStn").setValue(police_option);
                myref.child("Complain").child(name_edit.getText().toString()).child("status").setValue("0");

                myref.child("Police").child(police_option).child(name_edit.getText().toString()).child("name").setValue(name_edit.getText().toString());
                myref.child("Police").child(police_option).child(name_edit.getText().toString()).child("address").setValue(address_edit.getText().toString());
                myref.child("Police").child(police_option).child(name_edit.getText().toString()).child("complain").setValue(complain_edit.getText().toString());
                myref.child("Police").child(police_option).child(name_edit.getText().toString()).child("adharnumber").setValue(adhar_edit.getText().toString());
                myref.child("Police").child(police_option).child(name_edit.getText().toString()).child("status").setValue("0");
                myref.child("Police").child(police_option).child(name_edit.getText().toString()).child("policeStn").setValue(police_option);


                startActivity(closeFrag);
                Toast.makeText(getContext(),"Complain Added",Toast.LENGTH_LONG).show();


            }
        });
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        police_option = parent.getItemAtPosition(position).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}