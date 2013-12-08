package com.login_register;

import java.math.BigInteger;

import com.example.nutrition_guardian.R;
import com.user.MainPageUser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends Activity {

	private EditText firstname;
	private EditText lastname;
	private EditText birthdate;
	private EditText email;
	private Spinner langSpinner;
	private Button save;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		firstname = (EditText) findViewById(R.id.editText1);
		lastname = (EditText) findViewById(R.id.editText2);
		birthdate = (EditText) findViewById(R.id.editText3);
		email = (EditText) findViewById(R.id.editText4);
		save = (Button) findViewById(R.id.button1);
		langSpinner = (Spinner) findViewById(R.id.spinner1);
		
		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// Save into DB...

				showMessage("Your account is successfully created");
			}
		});

	}
	
	// To show message register
	private void showMessage(String message) {

		Context context = getApplicationContext();
		int duration = Toast.LENGTH_LONG;

		Toast toast = Toast.makeText(context, message, duration);
		toast.show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}