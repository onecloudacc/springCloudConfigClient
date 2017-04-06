package com.learn.springCloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author rajes
 * date    Apr 6, 20172:58:52 PM
 *
 */
@RestController
public class ClientConfigController {
	
	private static final Logger log = LoggerFactory.getLogger(ClientConfigController.class);
	
	@Value("${appName}")  // Printing the fieldnames from http://localhost:8001/configuration/default
	String myAppName;
	
	@Value("${desc}") 
	String description;
	
	@RequestMapping(method=RequestMethod.GET,value="/fetchConfig")
	public String getConfigDetails()
	{
		log.info("ClientConfig app is calling the ServerConfig app");
		log.info("Printing the config from the serverConfig app");
		log.info("AppName= " +myAppName  + "  Desc= "+description);
		return "AppName= " +myAppName  + "  Desc= "+description;
	}

}
