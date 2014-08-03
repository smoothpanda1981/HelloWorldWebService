package com.yan.wang.ws.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yan.wang.ws.model.HelloWorld;

@Controller
public class HelloWorldController {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    
    //Map to store employees, ideally we should use database
    Map<Integer, HelloWorld> hwData = new HashMap<Integer, HelloWorld>();
     
    @RequestMapping(value = EmpRestURIConstants.HELLO_WORLD, method = RequestMethod.GET)
    public @ResponseBody HelloWorld getHellowWorld() {
        logger.info("Start HelloWorld");
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMsg("Hello World");
        return helloWorld;
    }
}
