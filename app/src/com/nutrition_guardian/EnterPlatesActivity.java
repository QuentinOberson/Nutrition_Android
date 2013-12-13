package com.nutrition_guardian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nutrition_guardian.EnterPlates_graph;
import com.example.nutrition_guardian.R;

public class EnterPlatesActivity extends Activity {

	private Intent intent_enterPlates_graph;
	private Button next;

	private int part;
	private String size;
	
	private Spinner [] spinner = new Spinner[5];
	private EditText [] text = new EditText[5];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_plates);
		
		next = (Button) this.findViewById(R.id.button1);
		
		intent_enterPlates_graph = new Intent(this,EnterPlates_graph.class);
		
		Bundle extras = this.getIntent().getExtras();
		part = Integer.parseInt(extras.getString("part"));
		size = extras.getString("size");

		spinner[0] = (Spinner) this.findViewById(R.id.spinner1);
		spinner[1] = (Spinner) this.findViewById(R.id.spinner2);
		spinner[2] = (Spinner) this.findViewById(R.id.spinner3);
		spinner[3] = (Spinner) this.findViewById(R.id.spinner4);
		spinner[4] = (Spinner) this.findViewById(R.id.spinner5);
		
		text[0] = (EditText) this.findViewById(R.id.editText1);
		text[1] = (EditText) this.findViewById(R.id.editText2);
		text[2] = (EditText) this.findViewById(R.id.editText3);
		text[3] = (EditText) this.findViewById(R.id.editText4);
		text[4] = (EditText) this.findViewById(R.id.editText5);
		
		for (int i = part; i < spinner.length; i++) {
			spinner[i].setVisibility(View.INVISIBLE);
			text[i].setVisibility(View.INVISIBLE);
		}
		
		next.setOnClickListener(nextButtonListener);
	}

	public void getNoPartsAndSize(String parts, String size){
		this.part = Integer.parseInt(parts);
		this.size = size;
	}

	private OnClickListener nextButtonListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// redirect to enterPlatesGraph
			int sum = 0;
			int [] values = new int[part];
			String [] parts = new String[part];
			
			for (int i = 0; i < part; i++) {
				values[i] = Integer.parseInt(text[i].getEditableText().toString());
				parts[i] = spinner[i].getSelectedItem().toString();
				
				sum += Integer.parseInt(text[i].getEditableText().toString());
			}
			if (sum==100) {
				intent_enterPlates_graph.putExtra("values", values);
				intent_enterPlates_graph.putExtra("parts", parts);
				EnterPlatesActivity.this.startActivity(intent_enterPlates_graph);
			}
			else {
				Toast toast = Toast.makeText(EnterPlatesActivity.this, R.string.warningpourcentage, Toast.LENGTH_LONG);
				toast.show();
			}
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.enter_plates, menu);
		return true;
	}
}