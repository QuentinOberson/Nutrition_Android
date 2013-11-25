package com.rest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class Connexion {

	/**
	 * Trying something...
	 */
	
	
	protected String doInBackground(Void... params) {
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpContext localContext = new BasicHttpContext();
		HttpGet httpGet = new HttpGet("http://www.cheesejedi.com/rest_services/get_big_cheese.php?puzzle=1");
		String text = null;
		
		try {
		HttpResponse response = httpClient.execute(httpGet, localContext);


		HttpEntity entity = response.getEntity();


		//text = getASCIIContentFromEntity(entity);


		} catch (Exception e) {
		return e.getLocalizedMessage();
		}


		return text;
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
