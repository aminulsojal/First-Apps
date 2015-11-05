package com.example;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.text.format.DateFormat;


public class item {
	public String wishString;
	public Date date;
	public item(String wishString, Date date) {
		super();
		this.wishString = wishString;
		this.date = date;
	}
	public String getWishString() {
		return wishString;
	}
	public void setWishString(String wishString) {
		this.wishString = wishString;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDateTime() { 
		   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   Date date = new Date(); 
		   return dateFormat.format(date); 
	}

	
	
	

}
