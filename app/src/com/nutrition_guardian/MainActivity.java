package com.nutrition_guardian;

import com.example.nutrition_guardian.R;
import com.example.nutrition_guardian.TestRestActivity;
import com.login_register.LoginActivity;
import com.login_register.RegisterActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button buttonregister;
	private Button buttonlogin;
	private Button buttontestREST;

	private Intent intent_RegisterActivity;
	private Intent intent_LoginActivity;
	private Intent intent_restGet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Aktion aktion = new Aktion();

		buttonregister = (Button) this.findViewById(R.id.button2);
		buttonlogin = (Button) this.findViewById(R.id.button1);
		buttontestREST = (Button) this.findViewById(R.id.buttonRest);

		intent_RegisterActivity = new Intent(this, RegisterActivity.class);
		intent_LoginActivity = new Intent(this, LoginActivity.class);
		intent_restGet = new Intent(this, TestRestActivity.class);
		
		buttonregister.setOnClickListener(aktion);
		buttonlogin.setOnClickListener(aktion);
		buttontestREST.setOnClickListener(aktion);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class Aktion implements OnClickListener {

		@Override
		public void onClick(View view) {

			if (view == buttonregister) {
				MainActivity.this.startActivity(intent_RegisterActivity);
			}

			if (view == buttonlogin) {
				MainActivity.this.startActivity(intent_LoginActivity);
			}
			
			if (view == buttontestREST) {
				MainActivity.this.startActivity(intent_restGet);
			}

		}
	}
}