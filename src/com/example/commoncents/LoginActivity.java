package com.example.commoncents;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}
	
	public void goToMain(View view) {
		EditText loginText = (EditText)findViewById(R.id.loginText);
		EditText passwordText = (EditText)findViewById(R.id.passwordText);
		String login = loginText.getText().toString();
		String password = passwordText.getText().toString();
		if (LoginHandler.checkLogin(login, password)) {
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
		}
		else {
			loginText.setText("");
			passwordText.setText("");
			Toast.makeText(LoginActivity.this, "Wrong userID or password", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
	
	
	private static class LoginHandler {
		public static boolean checkLogin(String username, String password) {
			if (!RegisterActivity.activeUsers.containsKey(username))
				return false;
			if (password.equals(RegisterActivity.activeUsers.get(username)))
				return true;
			else
				return false;
		}
	}

}
