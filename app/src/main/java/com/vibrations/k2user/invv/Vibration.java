package com.vibrations.k2user.invv;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Vibration extends AppCompatActivity implements SensorEventListener {

    private TextView xText, yText, zText, rmsText;
    private Sensor mySensor;
    private SensorManager SM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vibration);


        SM = (SensorManager) getSystemService(SENSOR_SERVICE);

        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Hardcoding Sampling Rate to Fastest

        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_FASTEST);

        xText = (TextView) findViewById(R.id.xText);
        yText = (TextView) findViewById(R.id.yText);
        zText = (TextView) findViewById(R.id.zText);
        rmsText = (TextView) findViewById(R.id.rmsText);


    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        double a = Math.round(event.values[0] * 10000.0) / 10000.0;
        double b = Math.round(event.values[1] * 10000.0) / 10000.0;
        double c = Math.round(event.values[2] * 10000.0) / 10000.0;
        xText.setText("X: " + a);
        yText.setText("Y: " + b);
        zText.setText("Z: " + c);
        rmsText.setText("RMS: " + Math.sqrt((Math.pow(a, 2)) + (Math.pow(b, 2)) + (Math.pow(c, 2))));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //nothing
    }
}
