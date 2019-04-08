package com.example.connect;

import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.PrecomputedText;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.connect.Adapters.SliderAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout bottomlayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private Button nextButton;
    private Button previousButton;
    private int mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager=(ViewPager)findViewById(R.id.viewPager);
        bottomlayout=(LinearLayout) findViewById(R.id.bottomLayout);
        nextButton=(Button)findViewById(R.id.nextButton);
        previousButton=(Button)findViewById(R.id.PreviousButton);
        previousButton.setVisibility(View.INVISIBLE);


        sliderAdapter=new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage+1);
            }
        });
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage-1);
            }
        });



    }

    public void addDotsIndicator(int position){
        mDots=new TextView[3];
        bottomlayout.removeAllViews();
        for(int i =0 ;i<mDots.length;i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(50);
            mDots[i].setTextColor(getResources().getColor(R.color.Primary_Blue));
            bottomlayout.addView(mDots[i]);
        }
        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.Primary_Green));
        }
    }


    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage=i;
            if(i==0){

                nextButton.setEnabled(true);
                previousButton.setEnabled(false);
                nextButton.setText("Next");
                previousButton.setText("");
                previousButton.setVisibility(View.INVISIBLE);

            }
            else if(i==mDots.length-1){
                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
                previousButton.setVisibility(View.VISIBLE);
                nextButton.setText("LOGIN");
                previousButton.setText("PREVIOUS");

            }
            else{

                nextButton.setEnabled(true);
                previousButton.setEnabled(true);
                previousButton.setVisibility(View.VISIBLE);
                nextButton.setText("NEXT");
                previousButton.setText("PREVIOUS");

            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
