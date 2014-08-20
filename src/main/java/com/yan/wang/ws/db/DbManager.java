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
	 
	    	String URL =  "jdbc:mysql://mysql-ywang.appengine.flow.ch/Recette";
	    	
	    	Class.forName("com.mysql.jdbc.Driver"); 
	        Connection connection = DriverManager.getConnection(URL, "root", "OrlD5yJBpi");
	        System.out.println("CONNECTION: " + connection);
	 
	        return connection;
	    }
	 
	    public Employee getEmployee(String id, Connection conn) {
	    	Employee emp = new Employee();
	    	try {
	            Statement statement = conn.createStatement();
	            String sql = getEmployee + "'" + id + "'";
	            ResultSet rs = statement.executeQuery(sql);
	            int iden = Integer.parseInt(rs.getString(0));
	            String name = rs.getString(1);
	            Date date = rs.getDate(2);
	            
	            emp.setId(iden);
	            emp.setName(name);
	            emp.setCreatedDate(date);
	            
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
			return emp;
	    }
}
