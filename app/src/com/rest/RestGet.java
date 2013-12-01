package com.rest;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.os.AsyncTask;
import android.util.Log;

public class RestGet {

	/**
	 * Trying to get rest service
	 * 
	 * http://timewasted.net/?p=127
	 * http://stackoverflow.com/questions/3505930/make-an-http-request-with-android
	 * http://lukencode.com/2010/04/27/calling-web-services-in-android-using-httpclient/
	 */

	String URL = "http://yourURL";
	String result = "";
	String deviceId = "xxxxx";
	final String tag = "Your Logcat tag: ";

	
	public String callWebService(String q) {

		HttpClient httpclient = new DefaultHttpClient();
		HttpGet request = new HttpGet(URL + q);
		request.addHeader("deviceId", deviceId);
		ResponseHandler<String> handler = new BasicResponseHandler();

		try {

			result = httpclient.execute(request, handler);
			
			
		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// close connection
		httpclient.getConnectionManager().shutdown();
		Log.i(tag, result);
		
		return result ;
	}



}
