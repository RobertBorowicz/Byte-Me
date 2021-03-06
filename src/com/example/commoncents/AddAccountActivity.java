package com.example.commoncents;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class AddAccountActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_account);
		// Show the Up button in the action bar.
		setupActionBar();
	}
	
	public void accept(View view) {
		EditText accountNameText = (EditText)findViewById(R.id.accountName);
		EditText displayNameText = (EditText)findViewById(R.id.displayName);
		EditText accountOwnerText = (EditText)findViewById(R.id.accountOwner);
		EditText startingBalanceText = (EditText)findViewById(R.id.startingBalance);
		EditText interestText = (EditText)findViewById(R.id.interest);
		String accountName = accountNameText.getText().toString();
		String displayName = displayNameText.getText().toString();
		String accountOwner = accountOwnerText.getText().toString();
		String startingBalance = startingBalanceText.getText().toString();
		String interest = interestText.getText().toString();
		if (!accountName.equals("") && !displayName.equals("") && !accountOwner.equals("") && !startingBalance.equals("") && !interest.equals("")) {
			double startingBalanceNum = Double.parseDouble(startingBalance);
			double interestNum = Double.parseDouble(interest);
			Account account = new Account(accountName, displayName, accountOwner, startingBalanceNum, interestNum);
			MainActivity.accountsList.add(account);
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);	
		}
		else 
			this.decline(view);
	}
	
	
	public void decline(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);	
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
		getMenuInflater().inflate(R.menu.add_account, menu);
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
