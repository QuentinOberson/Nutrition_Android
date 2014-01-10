package com.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;

public class RestService extends AsyncTask<Void, Void, String> {


	public String getASCIIContentFromEntity(HttpEntity entity)
			throws IllegalStateException, IOException {

		InputStream in = entity.getContent();

		StringBuffer out = new StringBuffer();
		int n = 1;
		while (n > 0) {
			byte[] b = new byte[4096];
			n = in.read(b);

			if (n > 0)
				out.append(new String(b, 0, n));
		}

		return out.toString();
	}

	// GET = on reçoit un string
	public String GetString() {

		HttpClient httpclient = new DefaultHttpClient();
		HttpContext localContext = new BasicHttpContext();
		String result = "";
		HttpGet request = new HttpGet(
				"http://10.0.2.2:8080/TestRest/rest/hello2/coucou");

		try {
			HttpResponse response = httpclient.execute(request, localContext);

			HttpEntity entity = response.getEntity();

			result = getASCIIContentFromEntity(entity);

		} catch (Exception e) {
			return e.getLocalizedMessage();
		}

		return result;

	}

	// GET = on reçoit un objet
	public Object GetObject(String serviceAddress) {

		HttpClient httpclient = new DefaultHttpClient();
		HttpContext localContext = new BasicHttpContext();
		String result = null;
		HttpGet request = new HttpGet(
				serviceAddress);

		try {

			HttpResponse response = httpclient.execute(request, localContext);

			HttpEntity entity = response.getEntity();

			result = getASCIIContentFromEntity(entity);

			// jsonObject = new JSONObject(result) ;

		} catch (Exception e) {
			return e.getLocalizedMessage();
		}

		return result;

	}
	
	// GET = on reçoit une liste d'objets
	public String GetObjectList(String serviceAddress) {

		HttpClient httpclient = new DefaultHttpClient();
		HttpContext localContext = new BasicHttpContext();
		String result = null;
		HttpGet request = new HttpGet(
				serviceAddress);

		try {

			HttpResponse response = httpclient.execute(request, localContext);

			HttpEntity entity = response.getEntity();

			result = getASCIIContentFromEntity(entity);
			

		} catch (Exception e) {
			return e.getLocalizedMessage();
		}

		return result;

	}

	// POST = on envoie un objet
	public String PostObject(String stringUser, String serviceAddress) {

		HttpClient httpclient = new DefaultHttpClient();
		HttpPost post = new HttpPost(
				serviceAddress);
		post.setHeader("content-type", "application/json");

		StringEntity entity = null ;
		try {

			entity = new StringEntity(stringUser);
			post.setEntity(entity);

			HttpResponse resp = httpclient.execute(post);
			
			// These is the response of the server, display error message if not okay
			String respStr = EntityUtils.toString(resp.getEntity());

			
			if(!respStr.equals("false"))
			{
				return respStr;
			}
			else
			{
				return "false";
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "false";
	}
	
	// POST = on envoie une liste d'objets
		public void PostObjectList(String stringListUser) {

			HttpClient httpclient = new DefaultHttpClient();
			HttpPost post = new HttpPost(
					"http://10.0.2.2:8080/TestRest/rest/hello2/testList");
			post.setHeader("content-type", "application/json");

			StringEntity entity = null ;
			try {

				entity = new StringEntity(stringListUser);
				post.setEntity(entity);

				HttpResponse resp = httpclient.execute(post);
				
				// These is the response of the server, display error message if not okay
				String respStr = EntityUtils.toString(resp.getEntity());
				System.out.println(respStr.toString());
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		return null;
	}
}