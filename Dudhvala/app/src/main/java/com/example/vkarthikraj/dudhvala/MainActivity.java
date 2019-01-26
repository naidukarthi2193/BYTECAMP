package com.example.vkarthikraj.dudhvala;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView rates;
    private TextView txtEggs;
    private TextView txtMilk;
    private TextView txtBread;
    private EditText Qeggs;
    private EditText Qmilk;
    private EditText Qbread;
    private Button Checkout;
    private TextView txt;
    private TextView Result;
    private double pEggs=6.00, pMilk=34.50, pBread=24.25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEggs=(TextView) findViewById(R.id.textEggs);
        txtMilk=(TextView) findViewById(R.id.textMilk);
        txtBread=(TextView)findViewById(R.id.textBread);
        Qbread=(EditText)findViewById(R.id.editTextBread);
        Qeggs=(EditText)findViewById(R.id.editTextEggs);
        Qmilk=(EditText)findViewById(R.id.editTextMilk);
        Checkout=(Button)findViewById(R.id.checkout);
        Result=(TextView) findViewById(R.id.textViewResult);
        rates=(ImageView)findViewById(R.id.rates);
        txt=(TextView) findViewById(R.id.textView9);
        Checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double qeggs,qmilk,qbread,result;
                qeggs=Double.parseDouble(Qeggs.getText().toString());
                qbread=Double.parseDouble(Qbread.getText().toString());
                qmilk=Double.parseDouble(Qmilk.getText().toString());
                result=qeggs*pEggs+qbread*pBread+qmilk*qmilk;
                txtBread.setVisibility(View.INVISIBLE);
                txtEggs.setVisibility(View.INVISIBLE);
                txtMilk.setVisibility(View.INVISIBLE);
                Qeggs.setVisibility(View.INVISIBLE);
                Qmilk.setVisibility(View.INVISIBLE);
                Qbread.setVisibility(View.INVISIBLE);
                Checkout.setVisibility(View.INVISIBLE);
                rates.setVisibility(View.INVISIBLE);
                txt.setVisibility(View.VISIBLE);
                Result.setVisibility(View.VISIBLE);
                Result.setText(String.format("%.2f",result));

















            }
        });






    }
}
