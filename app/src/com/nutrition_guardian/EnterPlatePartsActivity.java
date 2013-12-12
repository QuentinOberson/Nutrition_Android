package com.nutrition_guardian;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.example.nutrition_guardian.R;

public class EnterPlatePartsActivity extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_plate_parts);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.enter_plates, menu);
		return true;
	}
}