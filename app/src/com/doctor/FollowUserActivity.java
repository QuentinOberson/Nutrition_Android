package com.doctor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.nutrition_guardian.R;
import com.nutrition_guardian.StatisticsActivity;

public class FollowUserActivity extends Activity {

	private Button buttonfollow;

	private Intent intent_stat;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_follow_user);

		setTitle(R.string.titleFollowUser);

		buttonfollow = (Button) this.findViewById(R.id.button1);

		intent_stat = new Intent(this, StatisticsActivity.class);

		// Statistic listener
		OnClickListener button1 = new OnClickListener() {
			@Override
			public void onClick(View v) {
				FollowUserActivity.this.startActivity(intent_stat);
			}
		};

		buttonfollow.setOnClickListener(button1);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}