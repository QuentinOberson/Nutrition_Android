package com.nutrition_guardian;

import java.util.Random;

import com.example.nutrition_guardian.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class EnterPlates extends Activity {

	// values of the plates
	private float values[] = { 20, 20, 20, 20 };
	private EditText edit1 ;
	private EditText edit2 ;
	private EditText edit3 ;
	private EditText edit4 ;
	private EditText edit5 ;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_plates);

		LinearLayout lv1 = (LinearLayout) findViewById(R.id.linear);
		EditText edit1 = (EditText) findViewById(R.id.editTextfood1);

		//int percent = Integer.parseInt(edit1.getText().toString());

		
		values = calculateData(values);
		MyGraphview graphview = new MyGraphview(this, values);
		lv1.addView(graphview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.enter_plates, menu);
		return true;
	}

	private float[] calculateData(float[] data) {
		float total = 0;
		for (int i = 0; i < data.length; i++) {
			total += data[i];
		}
		for (int i = 0; i < data.length; i++) {
			data[i] = 360 * (data[i] / total);
		}
		return data;
	}

	public class MyGraphview extends View {
		private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		private float[] value_degree;
		RectF rectf = new RectF(60, 60, 190, 190);
		float temp = 0;

		public MyGraphview(Context context, float[] values) {
		super(context);
		value_degree = new float[values.length];
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
