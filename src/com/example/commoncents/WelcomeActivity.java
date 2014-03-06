package com.example.commoncents;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void goToLogin(View view) {
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}
	
	public void goToRegister(View view) {
		Intent intent = new Intent(this, RegisterActivity.class);
		startActivity(intent);
	}

}
