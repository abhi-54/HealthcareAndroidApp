package com.example.healthcare;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Objects;

public class WaterAlarmFragment extends Fragment {

    private Button menBtn;
    private Button womenBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_water_alarm, container, false);
        menBtn=v.findViewById(R.id.men_btn);
        womenBtn=v.findViewById(R.id.women_btn);

        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        menBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainIntent();
            }
        });
        womenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent1();
            }
        });
    }

    private void mainIntent(){
        Intent mainIntent = new Intent(getActivity(),WaterAlarmActivity.class);
        startActivity(mainIntent);
        getActivity().finish();
    }
    private void mainIntent1(){
        Intent mainIntent1 = new Intent(getActivity(),WaterAlarmWomenActivity.class);
        startActivity(mainIntent1);
        getActivity().finish();
    }


}