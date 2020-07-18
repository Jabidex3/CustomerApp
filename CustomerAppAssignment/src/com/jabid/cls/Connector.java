package com.jabid.cls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class Connector {
	
// 	public static final String URL = "jdbc:mysql://database-17.cgsyjtny2rf9.us-east-2.rds.amazonaws.com:3306/CustomerApp";
//    public static final String USER = "admin";
//    public static final String PASS = "admin123";
    
    public static Connection getConnection()
    {
    	Properties props=new Properties();
		FileInputStream fis;
    	Connection conn = null;
    	try {
    		fis = new FileInputStream(new File("C:\\Java_Class_Two_WorkSpace\\CustomerAppAssignment\\src\\db.properties"));
			props.load(fis);
			DriverManager.registerDriver(new Driver());
			conn = DriverManager.getConnection(props.getProperty("URL"), props.getProperty("USERNAME"), props.getProperty("PASSWORD"));
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return conn;
    	
    }
}
