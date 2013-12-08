package com.example.nutrition_guardian;

import java.util.Random;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

public class EnterPlates_graph extends Activity {

	// values of the plates
	private int values[] = { 20, 20, 20, 20, 20 };
	private LinearLayout lv1 ;
	private int value1 = 0 ;
	private int value2 = 0 ;
	private int value3 = 0 ;
	private int value4 = 0 ;
	private int value5 = 0 ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_plates_graph);
		
		Bundle b = getIntent().getExtras();

		// Set the value from before
		value1 = Integer.parseInt( b.getString("edit1").toString());
		value2 = Integer.parseInt( b.getString("edit1").toString());
		value3 = Integer.parseInt( b.getString("edit1").toString());
		value4 = Integer.parseInt( b.getString("edit1").toString());
		value5 = Integer.parseInt( b.getString("edit1").toString());
		
		values[0] = value1 ;
		values[1] = value2 ;
		values[2] = value3 ;
		values[3] = value4 ;
		values[4] = value5 ;
		
		
		// Create the graph
		lv1 = (LinearLayout) findViewById(R.id.linear);
		values = calculateData(values);
		MyGraphview graphview = new MyGraphview(null, values);
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
		RectF rectf = new RectF(60, 60, 190, 190);
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
			Random r;
			for (int i = 0; i < value_degree.length; i++) {
				if (i == 0) {
					r = new Random();
					int color = Color.argb(100, r.nextInt(256), r.nextInt(256),
							r.nextInt(256));
					paint.setColor(color);
					canvas.drawArc(rectf, 0, value_degree[i], true, paint);
				} else {
					temp += value_degree[i - 1];
					r = new Random();
					int color = Color.argb(255, r.nextInt(256), r.nextInt(256),
							r.nextInt(256));
					paint.setColor(color);
					canvas.drawArc(rectf, temp, value_degree[i], true, paint);
				}
			}
		}
	}
}
