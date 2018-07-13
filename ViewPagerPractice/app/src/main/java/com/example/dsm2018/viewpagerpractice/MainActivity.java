package com.example.dsm2018.viewpagerpractice;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ViewPager vp;
    ImageButton leftBtn, rightBtn;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main_toolbar); //툴바설정
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

        vp = (ViewPager) findViewById(R.id.view_main_view);
        leftBtn = (ImageButton) findViewById(R.id.button_main_left);
        rightBtn = (ImageButton) findViewById(R.id.button_main_right);

        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);

        leftBtn.setOnClickListener(movePageListener);
        rightBtn.setOnClickListener(movePageListener);


    }


    View.OnClickListener movePageListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            int tag = (int) v.getTag();
            vp.setCurrentItem(tag);
        }
    };

    private class pagerAdapter extends FragmentStatePagerAdapter{

        public pagerAdapter(android.support.v4.app.FragmentManager fm){
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position){
            switch (position){
                case 0:
                    return new FirstFragment();
                case 1 :
                    return new SecondFragment();
                case 2 :
                    return new ThirdFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount(){  //ViewPager 안에 들어가는 Page 갯수
            return 3;
        }


    }




}
