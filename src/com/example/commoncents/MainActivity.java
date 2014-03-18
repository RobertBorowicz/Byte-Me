package com.example.commoncents;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class MainActivity extends Activity {
	
	public static ArrayList<Account> accountsList = new ArrayList<Account>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Show the Up button in the action bar.
		setupActionBar();
		this.createAccount(findViewById(android.R.id.content));
	}
	
	public void addAccount(View view) {
		Intent intent = new Intent(this, AddAccountActivity.class);
		startActivity(intent);
	}
	
	
	private void createAccount(View view) {
		if (!accountsList.isEmpty()) {
			for (int i=0; i<accountsList.size(); i++) {
				Button newButton = new Button(this);
				newButton.setText(accountsList.get(i).getDisplayName());
				LinearLayout ll = (LinearLayout) findViewById(R.id.buttonLayout);
				LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
				ll.addView(newButton, lp);
				final int index = i;
				
				newButton.setOnClickListener(new View.OnClickListener() {
		             public void onClick(View v) {
		                Intent intent = new Intent(MainActivity.this, AccountActivity.class);
		                intent.putExtra("fuck", index);
		                startActivity(intent);
		             }
		         });
					
			}
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
		getMenuInflater().inflate(R.menu.main, menu);
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
