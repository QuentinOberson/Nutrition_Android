package com.example.nutrition_guardian;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.example.businessentities.Commonuser;
import com.example.businessentities.Food;
import com.example.businessentities.Plate;
import com.example.businessentities.Platetofood;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.login_register.LoginActivity;
import com.nutrition_guardian.MainActivity;
import com.nutrition_guardian.StatisticsActivity;
import com.rest.RestService;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class EnterPlates_graph extends Activity {

	// values of the plates
	private int values[];
	private String parts[];
	private LinearLayout lv1 ;
	private List<Food> foods = new ArrayList<Food>();
	private Button save ;
	private Intent intent_statistics ; 
	private Commonuser userIntent;
	private Food[] listFoodToSend = new Food[5];
	
	private AutoCompleteTextView[] autocomplete = new AutoCompleteTextView[5];
	private EditText[] text = new EditText[5];
	
	//private AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_plates_graph);
		
		userIntent = (Commonuser) getIntent().getSerializableExtra("objet");
		
		save = (Button) this.findViewById(R.id.button1);

		setTitle(R.string.titlegraph);
		
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
		
		getAllFoods();
		
		ArrayAdapter<Food> adapter = new ArrayAdapter<Food>(this,android.R.layout.simple_dropdown_item_1line, foods);
		
		//Set the adapter and listener
		for (int i = 0; i<autocomplete.length ; i++){
			autocomplete[i].setAdapter(adapter);
			
			final int j = i;
			
			autocomplete[i].setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapter, View view, int index, long id) {
					Food f = (Food) adapter.getItemAtPosition(index);
					listFoodToSend[j] = f;
				}
			});
		}

		intent_statistics = new Intent(this, StatisticsActivity.class);
		save.setOnClickListener(new Aktion());
		Bundle b = getIntent().getExtras();
		values = b.getIntArray("values");
		parts = b.getStringArray("parts");
		
		
		for (int i = parts.length; i < text.length; i++) {
			autocomplete[i].setVisibility(View.INVISIBLE);
			text[i].setVisibility(View.INVISIBLE);
		}
		for (int i = 0; i < parts.length; i++) {
			autocomplete[i].setHint(values[i]+"% "+parts[i]);
		}

		// Create the graph
		lv1 = (LinearLayout) findViewById(R.id.linear);
		values = calculateData(values);
		MyGraphview graphview = new MyGraphview(this, values);
		lv1.addView(graphview);

	}
	

	private class Aktion implements OnClickListener {

		@Override
		public void onClick(View view) {
			
			if (view == save) {
				
				//Save the plate
				Plate plateToSend = new Plate();
				
				plateToSend.setFkcommonuser(userIntent);
					
				
				//Send to the server
				Gson gson = new Gson();
				String json = gson.toJson(plateToSend) ;

				RestService rest1 = new RestService() ;
				
				String result = rest1.PostObject(json, "http://10.0.2.2:8080/movieplex7/webresources/plate/create");
				//The result contains the plate if succeeded
				
				if(!result.contains("Error report"))
				{
					Plate plate = gson.fromJson(result, Plate.class);
					
					List<Platetofood> listPlatetofoodToSend = new ArrayList<Platetofood>();
					
					for (int i=0 ; i<listFoodToSend.length ; i++){
						if(listFoodToSend[i] != null)
						{
							//MAYBE PLATETOFOODPK MISSING? + NEED THE ID OF THE PLATE!!!
							listPlatetofoodToSend.add(
									new Platetofood(listFoodToSend[i], Integer.valueOf(text[i].getText().toString()), plate));//add food and quantity
						}
					}
					
					
					json = gson.toJson(listPlatetofoodToSend);
					
					result = rest1.PostObject(json, "http://10.0.2.2:8080/movieplex7/webresources/platetofood/create");
					
					if(result.equals("true"))
					{
						EnterPlates_graph.this.startActivity(intent_statistics);
					}
				}
				else
				{
					//display error message
//					dlgAlert.setMessage("WARNING: your plate hasn't been saved!");
//					dlgAlert.setTitle("Warning");
//					dlgAlert.setPositiveButton("OK", null);
//					dlgAlert.setCancelable(true);
//					dlgAlert.create().show();
				}	
			}
		}
	}
	
	private Commonuser getCommonuser()
	{
		Gson gson = new Gson() ;
		RestService rest1 = new RestService() ;
		String json = rest1.GetObjectList("http://10.0.2.2:8080/movieplex7/webresources/commonuser/");
		
		Type collectionType = new TypeToken<List<Food>>(){}.getType();
		foods = gson.fromJson(json, collectionType);
		return null;//
	}
	
	private void getAllFoods()
	{
		Gson gson = new Gson() ;
		RestService rest1 = new RestService() ;
		String json = rest1.GetObjectList("http://10.0.2.2:8080/movieplex7/webresources/food/");
		
		Type collectionType = new TypeToken<List<Food>>(){}.getType();
		foods = gson.fromJson(json, collectionType);
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
		private Paint paintline = new Paint();
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
			//the black line in the graph
			paintline.setColor(Color.BLACK);
			paintline.setStyle(Style.STROKE);
			for (int j = 0; j < parts.length; j++) {
				if (j==0) {
					if (parts[j].equals("Vegetables")) {
						color = Color.rgb(0, 255, 102);
						autocomplete[j].setBackgroundColor(Color.rgb(0, 255, 102));
					}
					if (parts[j].equals("Meat")) {
						color = Color.rgb(153, 0, 0);
						autocomplete[j].setBackgroundColor(Color.rgb(153, 0, 0));
					}
					if (parts[j].equals("Carbohydrate")) {
						color = Color.rgb(255, 204, 51);
						autocomplete[j].setBackgroundColor(Color.rgb(255, 204, 51));
					}
					paint.setColor(color);					
					canvas.drawArc(rectf, 0-1, value_degree[j]+1, true, paintline);
					canvas.drawArc(rectf, 0, value_degree[j], true, paint);
				}
				else {
					temp += value_degree[j-1];
					if (parts[j].equals("Vegetables")) {
						color = Color.rgb(0, 255, 102);
						autocomplete[j].setBackgroundColor(Color.rgb(0, 255, 102));
					}
					if (parts[j].equals("Meat")) {
						color = Color.rgb(153, 0, 0);
						autocomplete[j].setBackgroundColor(Color.rgb(153, 0, 0));
					}
					if (parts[j].equals("Carbohydrate")) {
						color = Color.rgb(255, 204, 51);
						autocomplete[j].setBackgroundColor(Color.rgb(255, 204, 51));
					}
					paint.setColor(color);					
					canvas.drawArc(rectf, temp-1, value_degree[j]+1, true, paintline);
					canvas.drawArc(rectf, temp, value_degree[j], true, paint);
				}
			}
		}
	}
}