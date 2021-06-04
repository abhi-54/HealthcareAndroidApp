package com.example.healthcare;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_home, container, false);

        Button gotoFootstep = (Button) v.findViewById(R.id.footstep);
        Button gotoBMI = (Button) v.findViewById(R.id.bmi);
        Button gotoSensor = (Button) v.findViewById(R.id.sensor);
        Button gotoWater = (Button) v.findViewById(R.id.water);


        gotoFootstep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment gotoFootstepFragment = new FootstepFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, gotoFootstepFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        gotoBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment gotoBMIFragment = new BMIFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, gotoBMIFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        gotoSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment gotoSensorFragment = new SenseFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, gotoSensorFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        gotoWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment gotoWaterFragment = new WaterAlarmFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, gotoWaterFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return v;
    }
}