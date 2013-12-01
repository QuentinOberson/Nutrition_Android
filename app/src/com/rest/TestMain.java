package com.rest;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestGet rest = new RestGet();
		
		String result  = rest.callWebService("");
		
		System.out.println(result);
	}

}
