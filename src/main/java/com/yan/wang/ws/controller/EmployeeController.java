package com.yan.wang.ws.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yan.wang.ws.db.DbManager;
import com.yan.wang.ws.model.Employee;

@Controller
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
    
    @RequestMapping(value = EmpRestURIConstants.GET_EMPLOYEE, method = RequestMethod.GET)
    public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
        logger.info("Start getEmployee. ID="+empId);
        
        DbManager dbManager = new DbManager();
        Connection conn = null;
		try {
			conn = dbManager.createConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Employee emp = dbManager.getEmployee(String.valueOf(empId), conn);
        
        return empData.put(emp.getId(), emp);
    }
}
