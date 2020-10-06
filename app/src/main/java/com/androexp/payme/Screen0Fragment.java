package com.androexp.payme;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Screen0Fragment extends Fragment {

    private Button dashBoard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_screen0, container, false);
        dashBoard = view.findViewById(R.id.dashboard);
        handleBtnState();
        return view;
    }

    private void handleBtnState() {
        dashBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Screen1Fragment screen1Fragment = new Screen1Fragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                transaction.replace(R.id.main_view, screen1Fragment, screen1Fragment.getTag())
                        .commit();
            }
        });
    }
}