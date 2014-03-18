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

public class TransactionActivity extends Activity {
	
	boolean flag;
	double number = 0;
	int index;
	Account account;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transaction);
		// Show the Up button in the action bar.
		setupActionBar();
		
		Intent intent = getIntent();
		index = (Integer) intent.getSerializableExtra("fuck");
		account = MainActivity.accountsList.get(index);
	}
	
	public boolean onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.withdraw:
	            if (checked)
	                flag = true;
	            break;
	        case R.id.deposit:
	            if (checked)
	                flag = false;
	            break;
	    }
		return flag;
	}


	public void accept(View view) {
		EditText amountText = (EditText)findViewById(R.id.transaction);
		String amount = amountText.getText().toString();
		
		if (!amount.equals("")) {
			number = Double.parseDouble(amount);
			if (flag) {
				number *= -1;
				
			}
			account.setBalance(account.getBalance() + number);
		}
		Intent intent = new Intent(this, AccountActivity.class);
		intent.putExtra("fuck", index);
		startActivity(intent);
	}
	
	public void decline(View view) {
		Intent intent = new Intent(this, AccountActivity.class);
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
		getMenuInflater().inflate(R.menu.transaction, menu);
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
