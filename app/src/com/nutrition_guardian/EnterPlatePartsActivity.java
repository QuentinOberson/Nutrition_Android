package com.nutrition_guardian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nutrition_guardian.R;

public class EnterPlatePartsActivity extends Activity{

	private Button buttonenter;
	private Spinner spinnerpart;
	private Spinner spinnersize;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_plate_parts);

		buttonenter = (Button) this.findViewById(R.id.button1);

		spinnerpart = (Spinner) this.findViewById(R.id.spinner1);
		spinnersize = (Spinner) this.findViewById(R.id.spinner2);

		intent = new Intent(this, EnterPlatesActivity.class);

		//EnterPlates listener
		OnClickListener button1 = new OnClickListener() {
			@Override
			public void onClick(View v) {
				String itempart = spinnerpart.getSelectedItem().toString();
				String itemsize = spinnersize.getSelectedItem().toString();

				if (itempart.equals("1")||itempart.equals("2")||itempart.equals("3")||
						itempart.equals("4")||itempart.equals("5")) {
					intent.putExtra("part", itempart);
					intent.putExtra("size", itemsize);
					EnterPlatePartsActivity.this.startActivity(intent);
				}
				else {
					Toast toast = Toast.makeText(EnterPlatePartsActivity.this, R.string.warningparts,
							Toast.LENGTH_LONG);
					toast.show();
				}				
			}
		};
		buttonenter.setOnClickListener(button1);
	}
}