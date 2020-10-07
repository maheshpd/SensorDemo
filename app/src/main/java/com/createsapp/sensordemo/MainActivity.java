package com.createsapp.sensordemo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView textView;
    SensorManager sensorManager;
    float changedValue;

    //    List<Sensor> deviceSensor;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


       /* sensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        textView.setText(sensor.getPower() + "\n" +
                sensor.getVersion());*/

//        deviceSensor = sensorManager.getSensorList(Sensor.TYPE_ALL);

//        textView.setText(deviceSensor.toString());

//        printSensor();

//        specificSensor();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //light senssor send only one value
        changedValue = sensorEvent.values[0];
        textView.setText(String.valueOf(changedValue));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    //get specifica Sensor
   /* private void specificSensor() {
        if (sensorManager.getDefaultSensor(Sensor.TYPE_HEART_BEAT) != null) {
            textView.setText("This device has Sensor");
        } else {
            textView.setText("This device has no Sensor");
        }
    }*/

    //print sesnsor name
    /*private void printSensor() {
        for (Sensor sensor : deviceSensor) {
            textView.setText(textView.getText() + "\n" + sensor.getName());
        }
    }*/
}