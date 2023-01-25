package com.practice.main;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTest01 {
	  static { 
	        try { 
	            Class.forName("oracle.jdbc.driver.OracleDriver"); 
	        } catch(Exception e) { 
	            e.printStackTrace(); 
	        } 
	    } 
	    
	    @Test 
	    public void testConnection() { 
	        try(Connection con = DriverManager.getConnection( 
	        		"jdbc:oracle:thin:@localhost:1521:XE",
					"practice",
					"hwang123")){ 
	            System.out.println(con); 
	        } catch (Exception e) { 
	            fail(e.getMessage()); 
	        } 
	    
	    }    
	      
}
