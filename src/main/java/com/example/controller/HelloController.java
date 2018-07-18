package com.example.controller;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.EnvConfig;
import com.example.model.User;

@RestController
public class HelloController {

    @Autowired
    private EnvConfig envConfig;


    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
    
 
    
    @RequestMapping("/test")
    public String GetConfig()
    {
    	return  envConfig.getTitle();
    }


}