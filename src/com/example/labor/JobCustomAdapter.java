package com.example.labor;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class JobCustomAdapter extends ArrayAdapter<Job> {
	 Context context;
	 int layoutResourceId;
	 ArrayList<Job> data = new ArrayList<Job>();

	 public JobCustomAdapter(Context context, int layoutResourceId,
	   ArrayList<Job> data) {
	  super(context, layoutResourceId, data);
	  this.layoutResourceId = layoutResourceId;
	  this.context = context;
	  this.data = data;
	 }

	 @Override
	 public View getView(final int position, View convertView, ViewGroup parent) {
	  View row = convertView;
	  JobHolder holder = null;

	  if (row == null) {
	   LayoutInflater inflater = ((Activity) context).getLayoutInflater();
	   row = inflater.inflate(layoutResourceId, parent, false);
	   holder = new JobHolder();
	   holder.textName = (TextView) row.findViewById(R.id.textViewJobName);
	   holder.textDescription = (TextView) row.findViewById(R.id.textViewJobDesc);
	   holder.textJobLength = (TextView) row.findViewById(R.id.textViewWhen);
	   
	   holder.textPrice = (TextView) row.findViewById(R.id.textViewJobPrice);
	   holder.textLocation = (TextView) row.findViewById(R.id.textViewWhere);
	   holder.btnDelete = (Button) row.findViewById(R.id.buttonDelete);
	   row.setTag(holder);
	  } else {
	   holder = (JobHolder) row.getTag();
	  }
	  Job job = data.get(position);
	  //holder.textName.setText(job.getName());
	 // holder.textPrice.setText(job.getAddress());
	  //holder.textLocation.setText(job.getLocation());
/*	  holder.btnEdit.setOnClickListener(new OnClickListener() {

	   @Override
	   public void onClick(View v) {
	    // TODO Auto-generated method stub
	    Log.i("Edit Button Clicked", "**********");
	    Toast.makeText(context, "Edit button Clicked",
	      Toast.LENGTH_LONG).show();
	   }
	  });*/
	  holder.btnDelete.setOnClickListener(new OnClickListener() {

	   @Override
	   public void onClick(View v) {
	    data.remove(position);
	    notifyDataSetChanged();
	   }
	  });
	  return row;

	 }

	 static class JobHolder {
	  public TextView textJobLength;
	  public TextView textDescription;
	  TextView textName;
	  TextView textPrice;
	  TextView textLocation;
	  //Button btnEdit;
	  Button btnDelete;
	 }
	}

