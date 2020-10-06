package com.createsapp.sensordemo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    SensorManager sensorManager;

    List<Sensor> deviceSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        deviceSensor = sensorManager.getSensorList(Sensor.TYPE_ALL);

//        textView.setText(deviceSensor.toString());

        printSensor();

//        specificSensor();
    }

    private void specificSensor() {
        if (sensorManager.getDefaultSensor(Sensor.TYPE_HEART_BEAT) != null) {
            textView.setText("This device has Sensor");
        } else {
            textView.setText("This device has no Sensor");
        }
    }

    private void printSensor() {
        for (Sensor sensor : deviceSensor) {
            textView.setText(textView.getText() + "\n" + sensor.getName());
        }
    }
}