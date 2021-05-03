package com.example.healthcare;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.content.Context.SENSOR_SERVICE;
import static java.lang.Math.round;


public class FootstepFragment extends Fragment implements SensorEventListener {
    private TextView stepDetector, calorietextview, distancetextview;
    private SensorManager sensorManager;
    private Sensor mStepCounter, mStepDetector;
    private boolean isCounterSensorPresent, isDetectorSensorPresent;
    int count = 0;
    int detect = 0;
    int finalsteps= 0;
    double cal=0;
    double feet, distance;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_footstep, container, false);

        //stepCounter = v.findViewById(R.id.stepCount);
        stepDetector = v.findViewById(R.id.stepDetect);
        calorietextview = v.findViewById(R.id.calories);
        distancetextview = v.findViewById(R.id.tv_distance);

        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        sensorManager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null)
        {
            mStepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isCounterSensorPresent = true;
        }
        else {
            Toast.makeText(getContext(), "Step Counter Sensor is not present", Toast.LENGTH_LONG).show();
            isCounterSensorPresent = false;
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null) {
            mStepDetector = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
            isDetectorSensorPresent = true;
        }
        else {
            stepDetector.setText("Step Detector Sensor is not present");
            isDetectorSensorPresent = false;
        }

        return v;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == mStepCounter) {
            count = (int) sensorEvent.values[0];
            //stepCounter.setText(String.valueOf(count));
        }
        else if (sensorEvent.sensor == mStepDetector) {
            detect = (int) (detect + sensorEvent.values[0]);
            finalsteps = (int) count - detect;
            stepDetector.setText(String.valueOf(count));

            cal = (count * 0.045);
            calorietextview.setText(String.format("%.2f", cal));

            feet = (double) (count * 1.4);
            distance = (feet /3.28);
            distancetextview.setText(String.format("%.2f", distance));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onResume() {
        super.onResume();
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null)
            sensorManager.registerListener(this, mStepCounter, SensorManager.SENSOR_DELAY_UI);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null)
            sensorManager.registerListener(this, mStepDetector, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null)
            sensorManager.unregisterListener(this, mStepCounter);

        //if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null)
        //sensorManager.unregisterListener(this, mStepDetector);
    }

}