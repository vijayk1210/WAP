package com.mb.wapsanity.common;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mb.wapsanity.common.*;


public class DatabaseAccessObject {


	public List verifyContact(String email) throws SQLException {
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    List<Integer> contactResult = new ArrayList();
	    int contact=0;

	    try {
	        try {
				connection = DatabaseConnection.startConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        statement = connection.prepareStatement("Select SBMRFNUM from TPSBM where SBMEMAILID='"+email + "'");
	        resultSet = statement.executeQuery();
	        

	      while(resultSet.next()) {
	          //contactResult.add(i,resultSet.getInt("SBMRFNUM"));
	    	   int i=0;
	        	contact = resultSet.getInt("SBMRFNUM");
	        	contactResult.add(i,contact);
	        	System.out.println(contact);
	        	
	         i++;        	
	        	
	        }
	    } finally {
	    	DatabaseConnection.closeConnection(connection);
	        if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
	        if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
	        if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
	    }

	    return contactResult;

}
	
	public static void main(String args[]){
		
		DatabaseAccessObject obj1 = new DatabaseAccessObject();
		List list = new ArrayList();
		try {
		    String email="vijaywap216@india.com";	
			list = obj1.verifyContact(email);
			System.out.println("Number of contacts = "+list.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
