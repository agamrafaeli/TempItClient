package com.example.labor;

import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;

public class WelcomeActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		switch (which)
		{
			case R.id.buttonNewJob:
			{
				Intent i = new Intent(this,EmployerMainActivity.class);
				startActivity(i);
				
				return;
			}
			case R.id.button2:
			{
				Intent i = new Intent(this,WorkerMainActivity.class);
				startActivity(i);
				return;
			}
		}
		
	}

}
