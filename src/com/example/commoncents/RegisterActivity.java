package com.example.commoncents;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class RegisterActivity extends Activity {
	
	public static String username;
	public static String password;
	public static String email;
	
	public static HashMap<String, String> activeUsers = new HashMap<String, String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		// Show the Up button in the action bar.
		setupActionBar();
	}
	
	public void registerAccount(View view) {
		EditText usernameText = (EditText)findViewById(R.id.registerUsername);
		EditText passwordText = (EditText)findViewById(R.id.registerPassword);
		EditText emailText = (EditText)findViewById(R.id.registerEmail);
		username = usernameText.getText().toString();
		password = passwordText.getText().toString();
		email = emailText.getText().toString();
		if (RegisterHandler.checkRegister(username, password, email)) {
			activeUsers.put(username,  password);
			Intent intent = new Intent(this, WelcomeActivity.class);
			startActivity(intent);
		}
		else {
			usernameText.setText("");
			passwordText.setText("");
			emailText.setText("");
			Toast.makeText(RegisterActivity.this, "Invalid username, password, or email", Toast.LENGTH_SHORT).show();
		}
	}
	
	private static class RegisterHandler {
		public static boolean checkRegister(String username, String password, String email) {
			Pattern p3 = Pattern.compile("[A-Za-z]{1}[\\w\\.\\-]*@[A-Za-z]{1}[\\w\\.\\-]*(.com|.org|.net)");
			Matcher m3 = p3.matcher(email);
			if ((password.length() >= 8) && m3.find())
				return true;
			else
				return false;
		}
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
