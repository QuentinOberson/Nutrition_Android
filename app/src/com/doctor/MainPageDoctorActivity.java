package com.doctor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.nutrition_guardian.R;

public class MainPageDoctorActivity extends Activity {

	private Intent intent_Profil;
	private Intent intent_Follow;

	private Button buttonFollow;
	private Button buttonProfil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainpage_doctor);

		setTitle(R.string.titlemainpagedoctor);

		buttonFollow = (Button)this.findViewById(R.id.button1); 
		buttonProfil = (Button)this.findViewById(R.id.button2);

		intent_Follow = new Intent(this, FollowUserActivity.class);
		intent_Profil = new Intent(this, DoctorProfilActivity.class);		

		// Follow listener
		OnClickListener button1 = new OnClickListener() {
			@Override
			public void onClick(View v) {
				MainPageDoctorActivity.this.startActivity(intent_Follow);
			}
		};
		// Profil listener
		OnClickListener button2 = new OnClickListener() {
			@Override
			public void onClick(View v) {
				MainPageDoctorActivity.this.startActivity(intent_Profil);
			}
		};
		
		buttonFollow.setOnClickListener(button1);
		buttonProfil.setOnClickListener(button2);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}