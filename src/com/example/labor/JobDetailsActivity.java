package com.example.labor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class JobDetailsActivity extends Activity implements OnClickListener{
	
	public static final String JOB_NAME = "JobName";
	public static final String JOB_DESC = "JobDesc";
	public static final String JOB_CITY = "JobCity";
	public static final String JOB_CITY_RADIUS = "JobCityRadius";
	public static final String JOB_DATE = "JobDate";
	public static final String JOB_TIME = "JobTime";
	public static final String JOB_SALARY = "JobSalary";
	String jobname = "";
	String jobDesc = "";
	String jobCity = "";
	String jobCityRadius = "";
	String jobDate = "";
	String jobTime = "";
	String jobSalary = "";
	private EditText etJobTitle;
	private EditText etJobDesc;
	private Spinner spinnerCity;
	private EditText etJobCityRadius;
	private EditText etJobDate;
	private EditText etJobTime;
	private EditText etJobSalary;
	int index = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newjob);
		etJobTitle = (EditText) findViewById(R.id.editTextJobTitle);
		etJobDesc = (EditText) findViewById(R.id.EditTextJobDesc);
		spinnerCity = (Spinner) findViewById(R.id.spinnerCity);
		etJobCityRadius = (EditText) findViewById(R.id.editTextDistance);
		etJobDate = (EditText) findViewById(R.id.editTextDate);
		etJobTime = (EditText) findViewById(R.id.editTextTime);
		etJobSalary = (EditText) findViewById(R.id.editTextSalary);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.city_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerCity.setAdapter(adapter);
		index = getIntent().getIntExtra("index",0);
		if (getIntent().hasExtra("JOB"))
		{
			Intent intent = getIntent();
			Job job = (Job) intent.getParcelableExtra("JOB");
			//jobname = b.getString(JOB_NAME);
			etJobTitle.setText(job.jobCity);
			//jobDesc = b.getString(JOB_DESC);
			etJobDesc.setText(job.jobDesc);
			spinnerCity.setSelection(getCityPosition(job.jobCity));
			//etJobTitle.setText(job.jobname);
			//jobCityRadius = b.getString(JOB_CITY_RADIUS);
			etJobCityRadius.setText(job.jobCityRadius);
			//jobDate = b.getString(JOB_DATE);
			etJobDate.setText(job.jobDate);
			///jobTime = b.getString(JOB_TIME);
			etJobTime.setText(job.jobTime);
			//jobSalary = b.getString(JOB_SALARY);
			etJobSalary.setText(job.jobSalary);
		}			
		
		((Button)findViewById(R.id.buttonSaveJob)).setOnClickListener(this);
	}

	private int getCityPosition(String cityName) {
		String[] cities = getResources().getStringArray(R.array.city_array);
		for (int i=0; i<cities.length; i++)
			if (cities[i].equals(cityName))
				return i;
		return -1;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent resultData = new Intent();
		Job job = new Job();
		job.jobTitle = etJobTitle.getText().toString();
		job.jobDesc = etJobDesc.getText().toString();
		job.jobCity = getResources().getStringArray(R.array.city_array)[spinnerCity.getSelectedItemPosition()];
		job.jobCityRadius = Integer.parseInt(etJobCityRadius.getText().toString());
		job.jobDate = Integer.parseInt(etJobDate.getText().toString());
		job.jobTime = Integer.parseInt(etJobTime.getText().toString());
		job.jobSalary = Integer.parseInt(etJobSalary.getText().toString());
		
		resultData.putExtra("JOB", job);
		setResult(Activity.RESULT_OK, resultData);
		finish();
	}
}
