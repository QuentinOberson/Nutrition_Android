package com.example.nutrition_guardian;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.businessentities.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rest.LongRunningGetIO;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class TestRestActivity extends Activity {

	private TextView textView1 ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_rest);

		// GET , Récupération avec string
		/*
		LongRunningGetIO rest1 = new LongRunningGetIO() ;

		String resultat = (String) rest1.doInBackgroundObject() ;

		textView1 = (TextView) findViewById(R.id.textViewRest);

		textView1.setText(resultat) ;	
		 */
		
		// GET, Récupération avec objet
		/*
		LongRunningGetIO rest1 = new LongRunningGetIO() ;

		JSONObject resultat = (JSONObject) rest1.doInBackgroundObject() ;
		
		try {
			
			User user1 = new User() ;
			user1.setFirstname(resultat.getString("firstname"));
			
			textView1 = (TextView) findViewById(R.id.textViewRest);

			textView1.setText(user1.getFirstname()) ;
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
				
		// GET,  Receive json object depuis serveur
		/*
		LongRunningGetIO rest1 = new LongRunningGetIO() ;
		
		String resultat = (String) rest1.doInBackgroundObject() ;
		
		Gson gson = new Gson();
		
		User user1 = gson.fromJson(resultat, User.class);
		textView1 = (TextView) findViewById(R.id.textViewRest);
		textView1.setText(user1.getLastname()) ;
		*/

		// POST, Envoie gsonobject
		/*
		User user1 = new User(12, "Quentino", "Rappaz") ;
		Gson gson = new Gson();
		String json = gson.toJson(user1) ;
		
		LongRunningGetIO rest1 = new LongRunningGetIO() ;
		rest1.PostObject(json);
		*/
		
		
		// GET, Recevoir list objets
		/*
		Gson gson = new Gson() ;
		LongRunningGetIO rest1 = new LongRunningGetIO() ;
		String json = rest1.GetObjectList();
		
		Type collectionType = new TypeToken<List<User>>(){}.getType();
		List<User> ints2 = gson.fromJson(json, collectionType);
		
		textView1 = (TextView) findViewById(R.id.textViewRest);
		
		for (User user : ints2) {
			textView1.append(user.getLastname());
		}
		 */
		
		//POST  Envoie list objets
		List<User> listUsers = new ArrayList<User>() ;
		listUsers.add(new User(1, "Quentin", "Ducon")) ;
		listUsers.add(new User(2, "Robert", "De la couille")) ;
		listUsers.add(new User(3, "Gael", "De la moule")) ;
		
		Gson gson = new Gson() ;
		LongRunningGetIO rest1 = new LongRunningGetIO() ;
		rest1.PostObjectList(gson.toJson(listUsers));
		 
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test_rest, menu);
		return true;
	}

}
