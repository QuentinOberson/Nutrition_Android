package com.example.nutrition_guardian;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;

public class EnterPlates_graph extends Activity {

	// values of the plates
	private int values[];
	private String parts[];
	private LinearLayout lv1 ;
	
	private AutoCompleteTextView[] autocomplete = new AutoCompleteTextView[5];
	private EditText[] text = new EditText[5];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_plates_graph);
		
		autocomplete[0] = (AutoCompleteTextView) this.findViewById(R.id.autoCompleteTextView1);
		autocomplete[1] = (AutoCompleteTextView) this.findViewById(R.id.autoCompleteTextView2);
		autocomplete[2] = (AutoCompleteTextView) this.findViewById(R.id.autoCompleteTextView3);
		autocomplete[3] = (AutoCompleteTextView) this.findViewById(R.id.autoCompleteTextView4);
		autocomplete[4] = (AutoCompleteTextView) this.findViewById(R.id.autoCompleteTextView5);
		
		text[0] = (EditText) this.findViewById(R.id.editText1);
		text[1] = (EditText) this.findViewById(R.id.editText2);
		text[2] = (EditText) this.findViewById(R.id.editText3);
		text[3] = (EditText) this.findViewById(R.id.editText4);
		text[4] = (EditText) this.findViewById(R.id.editText5);
		
		Bundle b = getIntent().getExtras();
		values = b.getIntArray("values");
		parts = b.getStringArray("parts");
		
		for (int i = parts.length; i < text.length; i++) {
			autocomplete[i].setVisibility(View.INVISIBLE);
			text[i].setVisibility(View.INVISIBLE);
		}		

		// Create the graph
		lv1 = (LinearLayout) findViewById(R.id.linear);
		values = calculateData(values);
		MyGraphview graphview = new MyGraphview(this, values);
		lv1.addView(graphview);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.enter_plates_graph, menu);
		return true;
	}

	private int[] calculateData(int[] data) {
		float total = 0;
		for (int i = 0; i < data.length; i++) {
			total += data[i];
		}
		for (int i = 0; i < data.length; i++) {
			data[i] = (int) (360 * (data[i] / total));
		}
		return data;
	}

	public class MyGraphview extends View {

		private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		private int[] value_degree;
		RectF rectf = new RectF(50, 5, 180, 135);
		int temp = 0;

		public MyGraphview(Context context, int[] values) {
			super(context);
			value_degree = new int[values.length];
			for (int i = 0; i < values.length; i++) {
				value_degree[i] = values[i];
			}
		}

		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			int color = 0;
			for (int j = 0; j < parts.length; j++) {
				if (j==0) {
					if (parts[j].equals("Vegetables")) {
						color = Color.GREEN;
					}
					if (parts[j].equals("Meat")) {
						color = Color.RED;
					}
					if (parts[j].equals("Carbohydrate")) {
						color = Color.YELLOW;
					}
					paint.setColor(color);
					canvas.drawArc(rectf, 0, value_degree[j], true, paint);
				}
				else {
					temp += value_degree[j-1];
					if (parts[j].equals("Vegetables")) {
						color = Color.GREEN;
					}
					if (parts[j].equals("Meat")) {
						color = Color.RED;
					}
					if (parts[j].equals("Carbohydrate")) {
						color = Color.YELLOW;
					}
					paint.setColor(color);
					canvas.drawArc(rectf, temp, value_degree[j], true, paint);
				}
			}
		}
	}
}