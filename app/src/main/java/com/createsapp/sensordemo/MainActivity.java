package com.createsapp.sensordemo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView xtext, ytext, ztext;
    SensorManager sensorManager;
    float changedValue;
    Boolean isAccelerometerSensorAvailable, itIsNotFirstTime = false;
    private float currentX, currentY, currentZ, lastX, lastY, lastZ;
    private float xDifference, yDifference, zDifference;


    Boolean isTemperatureSensorAvailable;
    Boolean isHumiditySensorAvailable;
    Boolean isPressureSensorAvailable;
    Boolean isProximitySensorAvailable;
    private float shakeThreshold = 5f;


    //    List<Sensor> deviceSensor;
//    private Sensor tempSensor;
    private Sensor humiditySesor;
    private Sensor pressureSensor;
    private Sensor proximitySensor;
    private Sensor accekerometerSensor;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xtext = findViewById(R.id.xtext);
        ytext = findViewById(R.id.ytext);
        ztext = findViewById(R.id.ztext);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        //Temperature Sensor implement
        /*if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
            tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            isTemperatureSensorAvailable = true;
        } else {
            textView.setText("Temperature Sensor is not available");
            isTemperatureSensorAvailable = false;
        }*/

       /* sensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        textView.setText(sensor.getPower() + "\n" +
                sensor.getVersion());*/

//        deviceSensor = sensorManager.getSensorList(Sensor.TYPE_ALL);

//        textView.setText(deviceSensor.toString());

//        printSensor();

//        specificSensor();

        //Humidity Sensor
        /*if (sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY) != null) {
            humiditySesor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
            isHumiditySensorAvailable = true;
        } else {
            textView.setText("Humidity Sensor is not available");
            isHumiditySensorAvailable = false;
        }*/

        //Pressure Sensor
        /*if (sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) != null) {
            pressureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
            isPressureSensorAvailable = true;
        } else {
            isPressureSensorAvailable = false;
            textView.setText("Pressure Sensor is not Available");
        }*/

        //Proximity Sensor
       /* if (sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) != null) {
            proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            isProximitySensorAvailable = true;
        } else {
            isProximitySensorAvailable = false;
            textView.setText("Proximity Sensor is not Available");
        }*/

        //Shake Detection Sensor
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            accekerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            isAccelerometerSensorAvailable = true;
        } else {
            xtext.setText("Accelerometer sensor is not available");
            isAccelerometerSensorAvailable = false;
        }

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //light senssor send only one value
       /* changedValue = sensorEvent.values[0];
        textView.setText(String.valueOf(changedValue));*/

        //Temperature Sensor
//        textView.setText(sensorEvent.values[0] + " C");

        //Humidity Sensor
//        textView.setText(sensorEvent.values[0] + "%");

        //Pressure Sensor
//        textView.setText(sensorEvent.values[0] + " hPa");

        //Proximity Sensor
        /*textView.setText(sensorEvent.values[0] + "cm");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            vibrator.vibrate(500);
            //deprected in API 26
        }*/

        //AccelerometerSensor
        xtext.setText(sensorEvent.values[0] + "m/s2");
        ytext.setText(sensorEvent.values[1] + "m/s2");
        ztext.setText(sensorEvent.values[2] + "m/s2");

        currentX = sensorEvent.values[0];
        currentY = sensorEvent.values[1];
        currentZ = sensorEvent.values[2];

        if (itIsNotFirstTime) {
            xDifference = Math.abs(lastX - currentX);
            yDifference = Math.abs(lastY - currentY);
            zDifference = Math.abs(lastZ - currentZ);

            if ((xDifference > shakeThreshold && yDifference > shakeThreshold) ||
                    (xDifference > shakeThreshold && zDifference > shakeThreshold) ||
                    (yDifference > shakeThreshold && zDifference > shakeThreshold)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(500);
                    //deprected in API 26
                }
            }
        }

        lastX = currentX;
        lastY = currentY;
        lastZ = currentZ;
        itIsNotFirstTime = true;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


    @Override
    protected void onResume() {
        super.onResume();
        //Light Sensor
//        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_NORMAL);

        //Temperature Sensor
        /*if (isTemperatureSensorAvailable) {
            sensorManager.registerListener(this, tempSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }*/

        //Humidity Sensor
        /*if (isHumiditySensorAvailable) {
            sensorManager.registerListener(this, humiditySesor, SensorManager.SENSOR_DELAY_NORMAL);
        }*/

        //Pressure Sensor
        /*if (isPressureSensorAvailable) {
            sensorManager.registerListener(this, pressureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }*/

        //Proximity Sensor
        /*if (isProximitySensorAvailable) {
            sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }*/

        //Accelerometer Sensor

        if (isAccelerometerSensorAvailable) {
            sensorManager.registerListener(this, accekerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Light Sensor
//        sensorManager.unregisterListener(this);

        //Temperature Sensor
        /*if (isTemperatureSensorAvailable) {
            sensorManager.unregisterListener(this);
        }*/

        //Humidity Sensor
       /* if (isHumiditySensorAvailable) {
            sensorManager.unregisterListener(this);
        }*/

        //Pressure Sensor
        /*if (isPressureSensorAvailable) {
            sensorManager.unregisterListener(this);
        }*/

        //Proximity SEnsor
        /*if (isProximitySensorAvailable) {
            sensorManager.unregisterListener(this);
        }*/

        //Accelometer Sensor
        if (isAccelerometerSensorAvailable) {
            sensorManager.unregisterListener(this);
        }

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