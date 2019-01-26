package com.example.vkarthikraj.to_do;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WorkAdapter extends ArrayAdapter<Works> {
    public WorkAdapter(Context context, List<Works> objects) {
        super(context,0, objects);
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View listItems =convertView;
        if(listItems == null)
        {
            listItems= LayoutInflater.from(getContext()).inflate(R.layout.each_list,parent,false);

        }
        Works newWord =getItem(position);
        TextView headingtext=(TextView) listItems.findViewById(R.id.heading_list);
        ImageView prioImage =(ImageView) listItems.findViewById(R.id.priorityImage);


        headingtext.setText(newWord.getWorks());

        switch (newWord.getPriority())
        {
            case 1:
                prioImage.setImageResource(R.drawable.green);
                break;
            case 2:
                prioImage.setImageResource(R.drawable.yellow);
                break;
            case 3:
                prioImage.setImageResource(R.drawable.red);
                break;
        }

        return listItems;





    }
}
