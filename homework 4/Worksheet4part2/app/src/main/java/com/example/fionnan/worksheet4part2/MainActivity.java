package com.example.fionnan.worksheet4part2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private String TAG = "FMCQT";

    private float lastX, lastY, lastZ;
    private float acceleration;
    private float currentAcceleration;
    private float lastAcceleration;

    private SeekBar seekBar;
    private WebView webView;


    private static int SIGNIFICANT_SHAKE = 50000;   //Tweak as necessary


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        acceleration = 0.00f;
        currentAcceleration = SensorManager.GRAVITY_EARTH;
        lastAcceleration = SensorManager.GRAVITY_EARTH;
        setContentView(R.layout.activity_main);


        seekBar = (SeekBar)findViewById(R.id.seekBar);
        webView = (WebView)findViewById(R.id.webView);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SIGNIFICANT_SHAKE = progress;
                Log.e(TAG, "New SIG SHAKE = " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        enableAccelerometerListening();
    }

    @Override
    protected void onStop() {
        disableAccelerometerListening();
        super.onStop();
    }


    private void enableAccelerometerListening(){
        SensorManager sensorManager =
                (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);


        sensorManager.registerListener(sensorEventListener,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }


    private void disableAccelerometerListening(){
        SensorManager sensorManager =
                (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);


        sensorManager.unregisterListener(sensorEventListener,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
    }

    private final SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];


            lastAcceleration = currentAcceleration;

            currentAcceleration = x * x + y * y + z * z;

            acceleration = currentAcceleration * (currentAcceleration - lastAcceleration);


            if (acceleration > 1200000){
                webView = (WebView)findViewById(R.id.webView);
                webView.loadUrl("https://jumpingjaxfitness.files.wordpress.com/2010/07/dizziness.jpg");
            }
            else if (acceleration > SIGNIFICANT_SHAKE){
                Log.i(TAG, "accelerstion " + acceleration);
                Log.i(TAG, "delta x = " + (x-lastX));
                Log.i(TAG, "delta y = " + (y-lastY));
                Log.i(TAG, "delta z = " + (z-lastZ));

                if (Math.abs(x) > Math.abs(y) && Math.abs(x)> Math.abs(z)){
                    webView = (WebView)findViewById(R.id.webView);
                    webView.loadUrl("http://google.com");
                }

                if (Math.abs(y) > Math.abs(x) && Math.abs(y) > Math.abs(z)){
                    webView = (WebView)findViewById(R.id.webView);
                    webView.loadUrl("http://yahoo.com");
                }

                if (Math.abs(z) > Math.abs(y) && Math.abs(z) > Math.abs(x)){
                    webView = (WebView)findViewById(R.id.webView);
                    webView.loadUrl("http://bing.com");
                }
            }

            lastX = x;
            lastY = y;
            lastZ = z;
            //setContentView(webView)
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
}
