package com.example.healthcare;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SenseFragment extends Fragment {
    private TextView textViewGarden;
    private TextView textViewAQI;
    private TextView textViewLEDstate;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_sense, container, false);

        textViewGarden = (TextView) v.findViewById(R.id.textViewMQ2);
        textViewAQI = (TextView) v.findViewById(R.id.textViewMQ4);
        textViewLEDstate = (TextView) v.findViewById(R.id.textViewMQ6);
        Button btnMQon = (Button) v.findViewById(R.id.btnMQ1);
        Button btnMQoff = (Button) v.findViewById(R.id.btnMQ2);

        btnMQon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("MQ135");
                myRef.child("LED").setValue("1");
            }
        });

        btnMQoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("MQ135");
                myRef.child("LED").setValue("0");
            }
        });


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference GardenRef = database.getReference("MQ135");

        GardenRef.addValueEventListener(new ValueEventListener() {

            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String AQI = snapshot.child("Air Quality").getValue().toString();
                String LED = snapshot.child("LED").getValue().toString();

                textViewAQI.setText(AQI);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("MQ135");

                if (Float.parseFloat(AQI) > 100.0){
                    textViewGarden.setText("Exceeded");
                    myRef.child("LED").setValue("1");
                }
                else {
                    textViewGarden.setText("Normal");
                    //myRef.child("LED").setValue("0");
                }

                if (LED.equals("1")){
                    textViewLEDstate.setText("ON");
                }
                else {
                    textViewLEDstate.setText("OFF");
                }
            }

            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /////////////////////////////////////////////////////////////////////////

        return v;
    }
}