package com.user;

import com.example.nutrition_guardian.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;

public class UserProfil extends Activity {

	private EditText firstname ;
	private EditText lastname;
	private EditText email;
	private EditText password ;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profil);
		
		firstname = (EditText) findViewById(R.id.editText1);
		firstname = (EditText) findViewById(R.id.editText2);
		firstname = (EditText) findViewById(R.id.editText3);
		firstname = (EditText) findViewById(R.id.editText4);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_profil, menu);
		return true;
	}

}
