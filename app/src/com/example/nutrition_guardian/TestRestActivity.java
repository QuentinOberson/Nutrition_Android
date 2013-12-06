package com.example.nutrition_guardian;

import com.rest.LongRunningGetIO;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class TestRestActivity extends Activity {

	private TextView textView1 ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_rest);
		
		
		LongRunningGetIO rest1 = new LongRunningGetIO() ;
		
		String resultat = rest1.doInBackground1() ;
		
		textView1 = (TextView) findViewById(R.id.textViewRest);
		
		textView1.setText(resultat) ;
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test_rest, menu);
		return true;
	}

}
