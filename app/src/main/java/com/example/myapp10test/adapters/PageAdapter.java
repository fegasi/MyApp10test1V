package com.example.myapp10test.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;

    public PageAdapter(@NonNull FragmentManager fm,ArrayList<Fragment> fragment) {
        super(fm);
        this.fragments=fragment;
    }

    @NonNull

    public Fragment getItem(int position) {
        return fragments.get(position);
    }


    public int getCount() {
        return fragments.size();
    }

    @NonNull

    public Fragment createFragment(int position) {
        return null;
    }


    public int getItemCount() {
        return fragments.size();
    }
}
