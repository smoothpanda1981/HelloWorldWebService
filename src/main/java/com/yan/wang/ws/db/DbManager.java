package com.yan.wang.ws.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.yan.wang.ws.model.Employee;

public class DbManager {
	 private String getEmployee = "select * from Employee where id = ";
	 
	    public Connection createConnection() throws IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	 
	    	String URL =  "jdbc:mysql://www.db4free.net:3306/yanwangdb";
	    	
	    	Class.forName("com.mysql.jdbc.Driver"); 
	        Connection connection = DriverManager.getConnection(URL, "ywang", "wafaouafah79");
	        System.out.println("CONNECTION: " + connection);
	 
	        return connection;
	    }
	 
	    public Employee getEmployee(String id, Connection conn) {
	    	Employee emp = new Employee();
	    	Statement statement = null;
	    	ResultSet rs = null;
	    	try {
	            statement = conn.createStatement();
	            String sql = getEmployee + " " + id + " ";
	            rs = statement.executeQuery(sql);
	            
	            while (rs.next()) {
//	            	System.out.println("id = " + rs.getInt(1));
	            	int iden = rs.getInt("id");
		            String name = rs.getString("name");
		            Date date = rs.getDate("date");
		            
		            System.out.println(iden);
		            System.out.println(name);
		            System.out.println(date.toString());
		            
		            emp.setId(iden);
		            emp.setName(name);
		            emp.setCreatedDate(date);
	            }
	            
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	        	try {
	        		if (statement != null) {
	        			statement.close();
	        		}
	        		if (rs != null) {
	        			rs.close();
	        		}
	        	} catch (SQLException e) {
	        		e.printStackTrace();
	        	}
	        }
			return emp;
	    }
}
