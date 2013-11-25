package com.user;


import com.example.nutrition_guardian.R;
import com.nutrition_guardian.EnterPlates;
import com.nutrition_guardian.Statistics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainPageUser extends Activity {

	private Intent intent_Profil;
	private Intent intent_Plates;
	private Intent intent_Statistics;
	
	private Button buttonProfil;
	private Button buttonPlates;
	private Button buttonStatistics;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainpage_user);
		
		buttonProfil = (Button)this.findViewById(R.id.button2); 
		buttonPlates = (Button)this.findViewById(R.id.button1); 
		buttonStatistics = (Button)this.findViewById(R.id.button3); 
		
		intent_Profil = new Intent(this, UserProfil.class);
		intent_Plates = new Intent(this, EnterPlates.class);
		intent_Statistics = new Intent(this, Statistics.class);
		
	     // Profil listener
	     OnClickListener button1 = new OnClickListener() {
	       @Override
	       public void onClick(View v) {
	    	   MainPageUser.this.startActivity(intent_Profil);
	       }
	     };
	     
	     // Plates listener
	     OnClickListener button2 = new OnClickListener() {
	       @Override
	       public void onClick(View v) {
	    	   MainPageUser.this.startActivity(intent_Plates);;
	       }
	     };
	     
	     // Statistics listener
	     OnClickListener button3 = new OnClickListener() {
	       @Override
	       public void onClick(View v) {
	    	   MainPageUser.this.startActivity(intent_Statistics);
	       }
	     };
	     
	     buttonProfil.setOnClickListener(button1);
	     buttonPlates.setOnClickListener(button2);
	     buttonStatistics.setOnClickListener(button3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
