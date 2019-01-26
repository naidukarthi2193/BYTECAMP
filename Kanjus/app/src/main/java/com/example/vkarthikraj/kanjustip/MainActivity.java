package com.example.vkarthikraj.kanjustip;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import javax.microedition.khronos.egl.EGLDisplay;

public class MainActivity extends AppCompatActivity {

    private EditText editname;
    private EditText editbill;
    private String Name;


    private CheckBox neat;
    private CheckBox manner;
    private CheckBox attend;
    private RadioGroup radgrp;
    private RadioButton radbut;
    private SeekBar scalar;
    private TextView scaletxt;
    private Button but;
    private static double a;
    private double Tip,Bill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Link variables
        editname=(EditText) findViewById(R.id.editName);
        editbill=(EditText) findViewById(R.id.editBill);
        neat=(CheckBox) findViewById(R.id.checkNeat);
        manner=(CheckBox) findViewById(R.id.checkManner);
        attend=(CheckBox) findViewById(R.id.checkAttentive);
        radgrp=(RadioGroup)findViewById(R.id.radioGroup);
        scalar=(SeekBar) findViewById(R.id.scaleBar);
        scaletxt=(TextView)findViewById(R.id.scale);
        but=(Button)findViewById(R.id.calculate);
        //RadioGrp
        radgrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                radbut=(RadioButton)findViewById(checkedId);

                if(radbut.getId() == R.id.radioLate)
                    Tip=Tip-5;
                if(radbut.getId() == R.id.radioQuick)
                    Tip=Tip+5;


            }
        });


       //seekbar
        scalar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                scaletxt.setText("Percentage :"+scalar.getProgress()+" / 100");

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                a= (scalar.getProgress());
            }
        });
        //Button
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name=editname.getText().toString();
                Bill=Double.valueOf(editbill.getText().toString());
                Double a_Bill=(Bill/10)*(a/100);


                //CheckBoxes
                if(neat.isChecked()) {
                    Tip=Tip+5;
                }
                if(manner.isChecked()) {
                    Tip=Tip+5;
                }
                if(attend.isChecked()) {
                    Tip=Tip+5;
                }
                Tip += a_Bill;
                final AlertDialog.Builder alert_a = new AlertDialog.Builder(MainActivity.this);
                alert_a.setCancelable(false);

                alert_a.setTitle("Kanjus Itna Toh Tip de");
                alert_a.setMessage(String.format("Ye Hai Tip  " + Name + "  ka ab Mukhwas leke bhag \n" +
                        "Rs. %.2f", Tip));
                alert_a.setPositiveButton("Pay and get Out", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                });

                alert_a.setNegativeButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Tip=0.0;
                    }
                });
                AlertDialog aleart = alert_a.create();
                aleart.show();
            }
        });

    }
}
