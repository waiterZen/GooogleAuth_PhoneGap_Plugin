package com.waiter.phonegap.oauth2Plugins;

import nimbusbase.client.GDriveClient;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;

public class googleAuth extends CordovaPlugin {
	public static final String ACTION_START_AUTH = "start_auth";

	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {

		try {
			if (ACTION_START_AUTH.equals(action)) {
//				 JSONObject arg_object = args.getJSONObject(0);
//				 String  username = arg_object.getString("username");
//				 String  password =  arg_object.getString("password");
//				   
//				Intent intent = new Intent();
//
//				intent.putExtra("username", username);
//				intent.putExtra("password", password);
				
//				System.out.println("get args:" + username + "::" + password);
			 
				GDriveClient client = new GDriveClient(null, null, this.cordova.getActivity());
				
				client.authorize();
				int count = 0;
				
				 while( (client.getAuthToken()==null ||client.getAuthToken().length() <10) &&  (count < 5)){
					 count++;
					 Thread.sleep(1000);
				 }
				
				System.out.println("get token~!!!" +  client.getAuthToken());
				
				if(client.getAuthToken() != null &&  client.getAuthToken().length() > 10){
					 callbackContext.success(client.getAuthToken());
					 return true;
				}else{
					callbackContext.error("authorize  fail");
					return false;
				}
				
				
			}
			callbackContext.error("Invalid action");
			return false;
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
			callbackContext.error(e.getMessage());
			return false;
		}

	};

}