package com.yan.wang.ws.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CurrencyConverterController {
	private static final Logger logger = LoggerFactory.getLogger(CurrencyConverterController.class);
    
    @SuppressWarnings("deprecation")
	@RequestMapping(value = "/currency/{rate}", method = RequestMethod.GET)
    public @ResponseBody String getCurrencyRate(@PathVariable("rate") String rate) {
        logger.info("Start Get Currency Rate");
        @SuppressWarnings("deprecation")
		HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://quote.yahoo.com/d/quotes.csv?s="+ rate.toUpperCase() +"=X&f=l1&e=.csv");
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String responseBody = "";
		try {
			responseBody = httpclient.execute(httpGet, responseHandler);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        httpclient.getConnectionManager().shutdown();
        
        return responseBody;
    }
}
