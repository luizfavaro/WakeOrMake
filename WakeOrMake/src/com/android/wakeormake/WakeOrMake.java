package com.android.wakeormake;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WakeOrMake extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wake_or_make);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wake_or_make, menu);
		return true;
	}

}
