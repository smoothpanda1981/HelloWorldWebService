package com.yan.wang.ws.controller;

public class EmpRestURIConstants {
	public static final String DUMMY_EMP = "/rest/emp/dummy";
	public static final String HELLO_WORLD = "/rest/helloworld";
    public static final String GET_EMP = "/rest/emp/{id}";
    public static final String GET_ALL_EMP = "/rest/emps";
    public static final String CREATE_EMP = "/rest/emp/create";
    public static final String DELETE_EMP = "/rest/emp/delete/{id}";
    
    // POST
    public static final String CREATE_EMPLOYEE = "/emp";
    
    // GET {id}
    public static final String GET_EMPLOYEE = "/emp/{id}";
    
    // GET ALL
    public static final String GET_EMPPLOYEES = "/emp/all";
    
    // PUT {id}
    public static final String PUT_EMPLOYEE = "/emp/{id}";
    		
   // DELETE {id}
   public static final String DELETE_EMPLOYEE = "/emp/{id}";
}
