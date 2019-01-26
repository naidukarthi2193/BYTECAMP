package com.example.vkarthikraj.to_do;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;

public class List_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        ArrayList<Works> list_works = new ArrayList<Works>();

        list_works = (ArrayList<Works>) getIntent().getSerializableExtra("Array");
        WorkAdapter workadpt =new WorkAdapter(this,list_works);
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(workadpt);


















    }
}
