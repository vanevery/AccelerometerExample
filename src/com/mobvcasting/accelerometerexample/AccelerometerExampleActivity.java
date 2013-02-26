package com.mobvcasting.accelerometerexample;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class AccelerometerExampleActivity extends Activity implements SensorEventListener {

	private SensorManager sensorManager;
	private Sensor accelerometerSensor;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
	
	@Override
	protected void onResume() {
		super.onResume();
		sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
	}	

	@Override 
	protected void onPause() {
		super.onPause();
    	sensorManager.unregisterListener(this);
    }
	
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	public void onSensorChanged(SensorEvent event) {
		Log.v("Accel","X: " + event.values[0]);
		Log.v("Accel","Y: " + event.values[1]);
		Log.v("Accel","Z: " + event.values[2]);
	}
}

