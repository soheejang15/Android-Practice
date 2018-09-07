package com.example.dsm2018.tablyout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter{
    int tabCount;

    public TabPagerAdapter(FragmentPagerAdapter fm, int numberOfTabs){
        super(fm);
        this.tabCount = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0 :
                Tab1Fragment tab1 = new Tab1Fragment();
            case 1 :
                Tab2Fragment tab2 = new Tab2Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount(){
        return tabCount;
    }
}
