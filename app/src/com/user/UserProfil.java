package com.user;

import com.example.nutrition_guardian.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;

//when this screen is called, the editTextFields will be completed with the data of the user
//from the database.
//not enough time to implement, that this editTextFields automatically completed with the 
//data from the database
public class UserProfil extends Activity {

	@SuppressWarnings("unused")
	private EditText firstname;
	@SuppressWarnings("unused")
	private EditText lastname;
	@SuppressWarnings("unused")
	private EditText email;
	@SuppressWarnings("unused")
	private EditText password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profil);
		
		firstname = (EditText) findViewById(R.id.editText1);
		lastname = (EditText) findViewById(R.id.editText2);
		email = (EditText) findViewById(R.id.editText3);
		password = (EditText) findViewById(R.id.editText4);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_profil, menu);
		return true;
	}
}