package com.example.connect.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.connect.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;


    public SliderAdapter(Context context){
        this.context=context;
    }

    public int[] slide_images ={
            R.drawable.school,
            R.drawable.teacher,
            R.drawable.discussion
    };
     public String[] slide_information={
             "An One Point Access System For College",
             "A Better System to Connect to teacher",
             "Platform to Hold Discussions and Doubts"
     };

    public String[] slide_Headings={
            "COLLEGE",
            "TEACHER",
            "STUDENT"
    };


    @Override
    public int getCount() {
        return slide_Headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (ConstraintLayout) o ;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView centerImage = (ImageView)view.findViewById(R.id.centerImage);
        TextView slide_heading = (TextView)view.findViewById(R.id.slide_heading);
        TextView slide_info = (TextView)view.findViewById(R.id.infoText);

        centerImage.setImageResource(slide_images[position]);
        slide_info.setText(slide_information[position]);
        slide_heading.setText(slide_Headings[position]);

        container.addView(view);



        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
