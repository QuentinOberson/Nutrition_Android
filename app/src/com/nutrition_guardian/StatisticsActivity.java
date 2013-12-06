package com.nutrition_guardian;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nutrition_guardian.R;

public class StatisticsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statistics);
		
		List <String> ListStatistics = new ArrayList <String>();
		
		ListStatistics.add("hallo");
		ListStatistics.add("ciao");
		
		ArrayAdapter<String> adapterStat = new ArrayAdapter<String>(StatisticsActivity.this, android.R.layout.simple_list_item_1, ListStatistics);
		
		ListView lStat = (ListView) findViewById(R.id.listView1);
		lStat.setAdapter(adapterStat);
	}	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.statistics, menu);
		return true;
	}	
}