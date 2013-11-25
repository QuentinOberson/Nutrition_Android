package com.example.nutrition_guardian;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class EnterPlates extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_plates);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.enter_plates, menu);
		return true;
	}

}
