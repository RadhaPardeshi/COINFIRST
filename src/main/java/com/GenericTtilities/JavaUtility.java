package com.GenericTtilities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	
	 public int random() 
	 {
		 Random ran =new Random();
		 int random = ran.nextInt(500);
		 return random; 
	 }
	 
	 public String getSystemDate()
	 {
		 Date dt = new Date();
		  String date = dt.toString();
		  return date; 
	 }
	 
	 public String getSystemDateInFormat()
	 {
		 SimpleDateFormat dateformat =new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		 Date dt = new Date();
		 String sytemDateFormat = dateformat.format(dt);
		 return sytemDateFormat;
	 }
	 
}
