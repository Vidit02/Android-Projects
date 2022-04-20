package com.loginapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    int tabcount;
    public MyPagerAdapter(@NonNull FragmentManager fm, int tabcount) {
        super(fm, tabcount);
        this.tabcount = tabcount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case  0 : Fragment1Blank fragment1Blank = new Fragment1Blank();
                      return fragment1Blank;
            case  1 : Fragment2Blank fragment2Blank = new Fragment2Blank();
                    return fragment2Blank;
            case 2 : HomeFragment homeFragment = new HomeFragment();
                    return  homeFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
