package com.example.vkarthikraj.to_do;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int prio;
    private EditText work ;
    public ArrayList<Works> work_list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addbut = (Button)findViewById(R.id.addButton);
        Button viewbut =(Button) findViewById(R.id.viewButton);
        work =(EditText)findViewById(R.id.editText);
        RadioGroup radgrp =(RadioGroup)findViewById(R.id.radioGroup);


        radgrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.radioLow:
                        prio=1;
                        break;
                    case  R.id.radioMedium:
                        prio=2;
                        break;
                    case R.id.radioHigh:
                        prio=3;
                        break;
                }

            }
        });



        addbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,List_Activity.class);
                work_list.add(new Works(work.getText().toString(),prio));
                intent.putExtra("Array",work_list);
                startActivity(intent);
            }
        });

        viewbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnt = new Intent(MainActivity.this,List_Activity.class);
                intnt.putExtra("Array",work_list);
                startActivity(intnt);
            }
        });


    }
}
