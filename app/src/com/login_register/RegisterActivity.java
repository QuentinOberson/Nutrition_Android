package com.login_register;

import java.util.Date;

import com.example.businessentities.Commonuser;
import com.example.nutrition_guardian.R;
import com.google.gson.Gson;
import com.rest.RestService;
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
	private EditText email;
	private EditText password;
	private Spinner langSpinner;
	private Button save;
	private EditText birthdateDay;
	private EditText birthdateMonth;
	private EditText birthdateYear;
	int day  = 0 ;
	int month = 0;
	int year = 0 ;
	private Intent intent_mainUserPage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		intent_mainUserPage = new Intent(this, MainPageUser.class);

		firstname = (EditText) findViewById(R.id.editText1);
		lastname = (EditText) findViewById(R.id.editText2);
		email = (EditText) findViewById(R.id.editText4);
		password = (EditText) findViewById(R.id.editText5);

		save = (Button) findViewById(R.id.button1);
		langSpinner = (Spinner) findViewById(R.id.spinner1);

		save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				int language = (int) langSpinner.getSelectedItemId()+1;
				
				birthdateDay = (EditText) findViewById(R.id.editText3a);
				birthdateMonth = (EditText) findViewById(R.id.editText3b);
				birthdateYear = (EditText) findViewById(R.id.editText3c);

				day = Integer.parseInt(birthdateDay.getText().toString());
				month = Integer.parseInt(birthdateMonth.getText().toString());
				year = Integer.parseInt(birthdateYear.getText().toString());
				
				// Save into DB...
				@SuppressWarnings("deprecation")
				Date d = new Date(year-1900, month-1, day);
				Commonuser user1 = new Commonuser(firstname.getText().toString(), lastname.getText().toString(), d, email.getText().toString(), password.getText().toString(), language) ;

				Gson gson = new Gson();
				String json = gson.toJson(user1) ;

				RestService rest1 = new RestService() ;
				String result = rest1.PostObject(json, "http://10.0.2.2:8080/movieplex7/webresources/commonuser/create");

				if(result.equals("true"))
				{
					showMessage("Your account is successfully created");
					RegisterActivity.this.startActivity(intent_mainUserPage);//redirect
				}
				else
				{
					showMessage("Your account hasn't been saved!!!");
				}
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