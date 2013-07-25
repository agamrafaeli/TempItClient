package com.example.labor;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class EmployerMainActivity extends ListActivity implements OnClickListener{
	 ListView jobList;
	 JobCustomAdapter jobAdapter;
	 ArrayList<Job> jobArray = new ArrayList<Job>();

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.employer_main_activity);

	  /**
	   * add item in arraylist
	   */
	  
	  /**
	   * set item into adapter
	   */
	  jobAdapter = new JobCustomAdapter(EmployerMainActivity.this, R.layout.list_item, jobArray);
	  jobList = (ListView) findViewById(R.id.listViewJobs);
	  jobList.setItemsCanFocus(false);
	  jobList.setAdapter(jobAdapter);
	  /**
	   * get on item click listener
	   */
	  jobList.setOnItemClickListener(new OnItemClickListener() {

	   @Override
	   public void onItemClick(AdapterView<?> parent, View v,
	     final int position, long id) {
		   Job job = new Job();
		   // pass it to another component
		   Intent in = new Intent(EmployerMainActivity.this, JobDetailsActivity.class);
		   in.putExtra("JOB", job);
		   in.putExtra("index", position);
		   startActivity(in);

	   }
	  });

	  Button addJob = (Button)findViewById(R.id.buttonNewJob);
	  addJob.setOnClickListener(this);
	 }
	 
	 @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	          if (resultCode == RESULT_OK) {
	            Job job = data.getParcelableExtra("JOB");
	            int index = data.getIntExtra("index",0);
	            if (index>0)
	            {
	            	jobArray.set(index, job);
	            }
	            else
	            	jobArray.add(job);
            	jobAdapter.notifyDataSetChanged();

	          }
	     		
	}

	@Override
	public void onClick(View v) {
		   Intent in = new Intent(EmployerMainActivity.this, JobDetailsActivity.class);
		   in.putExtra("index", 0);
		   startActivity(in);
	}
}
