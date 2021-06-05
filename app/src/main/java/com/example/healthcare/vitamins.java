package com.example.healthcare;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class vitamins extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_vitamins, container, false);
        Button VitaminABtn = (Button) v.findViewById(R.id.vitamin_a);
        Button VitaminBBtn = (Button) v.findViewById(R.id.vitamin_b);
        Button VitaminCBtn = (Button) v.findViewById(R.id.vitamin_c);
        Button VitaminDBtn = (Button) v.findViewById(R.id.vitamin_d);
        Button VitaminEBtn = (Button) v.findViewById(R.id.vitamin_e);
        Button VitaminKBtn = (Button) v.findViewById(R.id.vitamin_k);

        VitaminABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment gotoVitaminAFragment = new VitaminAFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, gotoVitaminAFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        VitaminBBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment gotoVitaminBFragment = new VitaminBFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, gotoVitaminBFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        VitaminCBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment gotoVitaminCFragment = new VitaminCFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, gotoVitaminCFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        VitaminDBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment gotoVitaminDFragment = new VitaminDFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, gotoVitaminDFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        VitaminEBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment gotoVitaminEFragment = new VitaminEFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, gotoVitaminEFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        VitaminKBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment gotoVitaminKFragment = new VitaminKFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, gotoVitaminKFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return v;

    }
}