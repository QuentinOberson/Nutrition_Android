package com.nutrition_guardian;



import com.example.nutrition_guardian.EnterPlates_graph;
import com.example.nutrition_guardian.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class EnterPlatesActivity extends Activity {

	
	private EditText edit1;
	private EditText edit2;
	private EditText edit3;
	private EditText edit4;
	private EditText edit5;
	private Intent intent_enterPlates_graph;
	private Button next;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_plates);

		/*
		 * Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		 * ArrayAdapter<CharSequence> adapter =
		 * ArrayAdapter.createFromResource(this, R.array.food,
		 * R.layout.actionbar_spinner);
		 * 
		 * adapter.setDropDownViewResource(R.layout.actionbar_spinner_dropdown);
		 * spinner.setAdapter(adapter);
		 */

		/*
		intent_enterPlates_graph = new Intent(this, EnterPlates_graph.class);

		edit1 = (EditText) findViewById(R.id.editTextfood1);
		edit2 = (EditText) findViewById(R.id.editTextfood2);
		edit3 = (EditText) findViewById(R.id.editTextfood3);
		edit4 = (EditText) findViewById(R.id.editTextfood4);
		edit5 = (EditText) findViewById(R.id.editTextfood5);

		edit1.setText(0) ;
		edit1.setText(0) ;
		edit1.setText(0) ;
		edit1.setText(0) ;
		edit1.setText(0) ;
		
		intent_enterPlates_graph.putExtra("edit1", edit1.getText());
		intent_enterPlates_graph.putExtra("edit2", edit2.getText());
		intent_enterPlates_graph.putExtra("edit3", edit3.getText());
		intent_enterPlates_graph.putExtra("edit4", edit4.getText());
		intent_enterPlates_graph.putExtra("edit5", edit5.getText());

		next.setOnClickListener(nextButtonListener);
		*/
	}

	private View.OnClickListener nextButtonListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {

			// redirect to enterPlatesGraph
			EnterPlatesActivity.this.startActivity(intent_enterPlates_graph);
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.enter_plates, menu);
		return true;
	}

}
