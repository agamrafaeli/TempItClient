package com.example.labor;

import android.os.Parcel;
import android.os.Parcelable;

public class Job implements Parcelable{

	//String 
	String jobTitle = "";
	String jobDesc = "";
	String jobCity = "";
	int jobCityRadius;
	int jobDate ;
	int jobTime ;
	int jobSalary ;


	    // No-arg Ctor
	    public Job(){}

	    // all getters and setters go here //...

	    /** Used to give additional hints on how to process the received parcel.*/
	    @Override
	    public int describeContents() {
		// ignore for now
		return 0;
	    }

	    @Override
	    public void writeToParcel(Parcel pc, int flags) {
		pc.writeInt(jobCityRadius);
		pc.writeInt(jobDate);
		pc.writeInt(jobTime);
		pc.writeInt(jobSalary);
		
		pc.writeString(jobTitle);
		pc.writeString(jobDesc);
		pc.writeString(jobCity);
		
	   }

	   /** Static field used to regenerate object, individually or as arrays */
	  public static final Parcelable.Creator<Job> CREATOR = new Parcelable.Creator<Job>() {
	         public Job createFromParcel(Parcel pc) {
	             return new Job(pc);
	         }
	         public Job[] newArray(int size) {
	             return new Job[size];
	         }
	   };

	   /**Ctor from Parcel, reads back fields IN THE ORDER they were written */
	   public Job(Parcel pc){
	   	 jobCityRadius=  pc.readInt();
		 jobDate =  pc.readInt();
		 jobTime =  pc.readInt();
		 jobSalary =  pc.readInt();
	   	 jobTitle =  pc.readString();
		 jobDesc  = pc.readString();
		 jobCity  = pc.readString();
	  }
	
}
