package org.crisandsoft.getSensorList;

import java.util.Iterator;
import java.util.List;

import org.crisandsoft.getSensorList.R;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainGetSensorListActivity extends Activity {

	private SensorManager mSensorManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView texto = (TextView) findViewById(R.id.texto_sensores);
		
		texto.setText("");
		
		String aux;
		aux="";
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        List<Sensor> sensores = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        Iterator<Sensor> it_sen = sensores.iterator();
        Sensor item_sensor;
        while ( it_sen.hasNext() )
        {
        	item_sensor=it_sen.next();
        	aux=aux+"["+ item_sensor.getName()+"]\n";
        }
        texto.setText(aux);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
