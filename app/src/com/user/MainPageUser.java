package com.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.businessentities.Commonuser;
import com.example.nutrition_guardian.R;
import com.nutrition_guardian.EnterPlatePartsActivity;
import com.nutrition_guardian.StatisticsActivity;

public class MainPageUser extends Activity {

	private Intent intent_Profil;
	private Intent intent_Plates;
	private Intent intent_Statistics;
	private Intent intent_Photo;

	private Button buttonProfil;
	private Button buttonPlates;
	private Button buttonStatistics;
	private Button buttonPhoto;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainpage_user);

		setTitle(R.string.titlemainpageuser);

		buttonProfil = (Button)this.findViewById(R.id.button2); 
		buttonPlates = (Button)this.findViewById(R.id.button1); 
		buttonStatistics = (Button)this.findViewById(R.id.button3);
		buttonPhoto = (Button)this.findViewById(R.id.button4);

		intent_Profil = new Intent(this, UserProfil.class);
		intent_Plates = new Intent(this, EnterPlatePartsActivity.class);
		intent_Statistics = new Intent(this, StatisticsActivity.class);
		intent_Photo = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

		intent_Plates.putExtra("objet", (Commonuser) getIntent().getSerializableExtra("objet"));//VERY BAD CODE BUT NOT ENOUGH TIME TO OPTIMISE
		
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
				MainPageUser.this.startActivity(intent_Plates);
			}
		};
		// Statistics listener
		OnClickListener button3 = new OnClickListener() {
			@Override
			public void onClick(View v) {
				MainPageUser.this.startActivity(intent_Statistics);
			}
		};
		//Photo listener
		OnClickListener button4 = new OnClickListener(){
			@Override
			public void onClick(View v){
				MainPageUser.this.startActivityForResult(intent_Photo, 0);
			}
		};

		buttonProfil.setOnClickListener(button1);
		buttonPlates.setOnClickListener(button2);
		buttonStatistics.setOnClickListener(button3);
		buttonPhoto.setOnClickListener(button4);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}