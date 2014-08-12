package com.yan.wang.ws.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.yan.wang.ws.model.Employee;

public class DbManager {
	 private final static String getEmployee = "select * from employee where id = ";
	 
	    public Connection createConnection() throws IOException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
	 
	        Connection connection;
	         
//	        Properties prop = new Properties();
//	        System.out.println("test");
//	        prop.load(new FileInputStream(System.getProperty("user.home") + "/mydb.cfg"));
//	        String host = prop.getProperty("host").toString();
//	        String username = prop.getProperty("username").toString();
//	        String password = prop.getProperty("password").toString();
//	        String driver = prop.getProperty("driver").toString();
	        String host = "jdbc:mysql://mysql-ywang.appengine.flow.ch/Recette";
	        String username = "root";
	        String password = "OrlD5yJBpi";
	        String driver = "com.mysql.jdbc.Driver";
	 
	        
	        Class.forName(driver).newInstance();
	        System.out.println("--------------------------");
	        System.out.println("DRIVER: " + driver);
	        connection = DriverManager.getConnection(host, username, password);
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
