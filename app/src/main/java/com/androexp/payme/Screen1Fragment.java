package com.androexp.payme;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.material.tabs.TabLayout;

import net.cachapa.expandablelayout.ExpandableLayout;

public class Screen1Fragment extends Fragment {

    private View backBtn, moreBtn;
    private RelativeLayout r1, r2, r3, r4;
    private ImageView recentBtn;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private PagerAdapter pagerAdapter;
    private ExpandableLayout expandableLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_screen1, container, false);

        backBtn = view.findViewById(R.id.back_btn);
        moreBtn = view.findViewById(R.id.more_btn);
        r1 = view.findViewById(R.id.f_1);
        r2 = view.findViewById(R.id.f_2);
        r3 = view.findViewById(R.id.f_3);
        r4 = view.findViewById(R.id.f_4);
        recentBtn = view.findViewById(R.id.recent_btn);
        viewPager = view.findViewById(R.id.view_pager);
        tabLayout = view.findViewById(R.id.tab);
        expandableLayout = view.findViewById(R.id.expandable_layout);

        handleBtnClicks();
        handleViewPager();
        return view;
    }

    private void handleBtnClicks() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.main_view, new Screen0Fragment())
                        .commit();
            }
        });

        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                transaction.replace(R.id.main_view, CommonFragment.newInstance("You clicked on three dots button"))
                        .commit();
            }
        });

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.main_view, CommonFragment.newInstance("You clicked on friend Abay"))
                        .commit();
            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.main_view, CommonFragment.newInstance("You clicked on friend Golu"))
                        .commit();

            }
        });

        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.main_view, CommonFragment.newInstance("You clicked on friend Lakshay"))
                        .commit();

            }
        });

        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.main_view, CommonFragment.newInstance("You clicked on friend Yash"))
                        .commit();

            }
        });

        recentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableLayout.toggle();
            }
        });

        expandableLayout.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
            @Override
            public void onExpansionUpdate(float expansionFraction, int state) {
                recentBtn.setRotation(expansionFraction * 180);
            }
        });
    }

    private void handleViewPager() {
        pagerAdapter = new PagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager, true);
    }

}