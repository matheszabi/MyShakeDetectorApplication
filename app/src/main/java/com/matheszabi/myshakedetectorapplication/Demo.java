package com.matheszabi.myshakedetectorapplication;


import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.seismic.ShakeDetector;

public class Demo extends Activity implements ShakeDetector.Listener {
    @SuppressLint("SetTextI18n")
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector sd = new ShakeDetector(this);

        // A non-zero delay is required for Android 12 and up (https://github.com/square/seismic/issues/24)
        int sensorDelay = SensorManager.SENSOR_DELAY_GAME;//1

        sd.start(sensorManager, sensorDelay);

        TextView tv = new TextView(this);
        tv.setGravity(Gravity.CENTER);
        tv.setText("Shake me!");
        setContentView(tv, new ViewGroup.LayoutParams(MATCH_PARENT, MATCH_PARENT));
    }

    @Override public void hearShake() {
        Toast.makeText(this, "Shake detected", Toast.LENGTH_SHORT).show();
    }
}