package com.example.nutrition_guardian;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.businessentities.Commonuser;
import com.example.businessentities.Language;
import com.example.businessentities.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rest.RestService;
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

			
		// GET, Récupération avec objet
		/*
		RestService rest1 = new RestService() ;

		JSONObject resultat = (JSONObject) rest1.GetObject() ;
		
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
		RestService rest1 = new RestService() ;
		
		String resultat = (String) rest1.GetObject() ;
		
		Gson gson = new Gson();
		
		User user1 = gson.fromJson(resultat, User.class);
		textView1 = (TextView) findViewById(R.id.textViewRest);
		textView1.setText(user1.getLastname()) ;
		*/

		// POST, Envoie gson object
		/*
		User user1 = new User(12, "Quentino", "Rappaz") ;
		Gson gson = new Gson();
		String json = gson.toJson(user1) ;
		
		RestService rest1 = new RestService() ;
		rest1.PostObject(json);
		*/
		
		
		// GET, Recevoir list objets
		/*
		Gson gson = new Gson() ;
		RestService rest1 = new RestService() ;
		String json = rest1.GetObjectList();
		
		Type collectionType = new TypeToken<List<User>>(){}.getType();
		List<User> ints2 = gson.fromJson(json, collectionType);
		
		textView1 = (TextView) findViewById(R.id.textViewRest);
		
		for (User user : ints2) {
			textView1.append(user.getLastname());
		}
		*/
		
		//POST  Envoie list objets
		/*
		List<User> listUsers = new ArrayList<User>() ;
		listUsers.add(new User(1, "Quentin", "Ducon")) ;
		listUsers.add(new User(2, "Robert", "De la couille")) ;
		listUsers.add(new User(3, "Gael", "De la moule")) ;
		
		Gson gson = new Gson() ;
		RestService rest1 = new RestService() ;
		rest1.PostObjectList(gson.toJson(listUsers));
		*/
		
		//FINAL TEST
		/*
		Commonuser user1 = new Commonuser(12, "Quentino", "Rappaz", "password") ;
		user1.setBirthday(new Date(1991, 8, 27));
		user1.setEmail("blablabla@gmail.com");
		user1.setFklanguage(new Language(2));
		
		Gson gson = new Gson();
		String json = gson.toJson(user1) ;
		
		RestService rest1 = new RestService() ;
		rest1.PostObject(json, "http://10.0.2.2:8080/movieplex7/webresources/commonuser/");
		*/
		
		RestService rest1 = new RestService() ;
		
		String resultat = (String) rest1.GetObject("http://10.0.2.2:8080/movieplex7/webresources/commonuser/find/1") ;
		
		Gson gson = new Gson();
		
		Commonuser user1 = gson.fromJson(resultat, Commonuser.class);
		textView1 = (TextView) findViewById(R.id.textViewRest);
		textView1.setText(user1.getLastname() + " " + user1.getFirstname()) ;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test_rest, menu);
		return true;
	}

}
