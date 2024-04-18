package com.GenericTtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	Connection con=null;
	
	public Connection connectToDB() throws SQLException
	{
	//Step1: Register the database 
	 Driver driver=new Driver();
	 DriverManager.registerDriver(driver);
	 
	return con = DriverManager.getConnection(IPathConstant.DBURL,IPathConstant.DBUsername,IPathConstant.DBpassword);
	}
	
     public void executeAndgetData(String query,String actual,String expData) throws SQLException

     {
    	//Step3: Create Statement
    	 Statement state = con.createStatement();
    	//Step4: Execute Query
    	ResultSet result = state.executeQuery(query);
    	boolean flag = false;
    	
    	while(result.next())
    	{
    		if(actual.contains(expData))
    		{
    			flag=true;
    		}
    	}
    	if(flag==true)
    	{
    		System.out.println("--Data is verified--");
    	}
    	else {
			System.out.println("-- Data is not verified--");
		}
    	
     }
     
     public void colseDBConnection() throws SQLException
     {
    	 
    	 con.close();
     //Step5: Close the connection
     }
     
     public static void main(String[] args) throws SQLException {
    	 DatabaseUtility db=new DatabaseUtility();
    	 Connection conection=db.connectToDB();
    	 
    	 
	}

}
