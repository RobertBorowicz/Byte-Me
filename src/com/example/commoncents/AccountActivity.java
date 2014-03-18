package com.example.commoncents;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class AccountActivity extends Activity {
	
	Account account;
	int index;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);
		// Show the Up button in the action bar.
		setupActionBar();
		
		Intent intent = getIntent();
		index = (Integer) intent.getSerializableExtra("fuck");
		account = MainActivity.accountsList.get(index);
		
		TextView accountNameText = (TextView)findViewById(R.id.accountName);
		TextView displayNameText = (TextView)findViewById(R.id.displayName);
		TextView accountOwnerText = (TextView)findViewById(R.id.accountOwner);
		TextView startingBalanceText = (TextView)findViewById(R.id.startingBalance);
		TextView interestText = (TextView)findViewById(R.id.interest);
		
		accountNameText.setText(account.getAccountName());
		displayNameText.setText(account.getDisplayName());
		accountOwnerText.setText(account.getAccountOwner());
		startingBalanceText.setText("$" + account.getBalance());
		interestText.setText(account.getInterest() + "%");
	}
	
	public void makeTransaction(View view) {
		Intent intent = new Intent(this, TransactionActivity.class);
		intent.putExtra("fuck", index);
		startActivity(intent);
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account, menu);
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
