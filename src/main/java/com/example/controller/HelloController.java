package com.example.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.EnvConfig;

import javax.websocket.server.PathParam;

@RestController
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EnvConfig envConfig;



    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello "+name;
    }


    @RequestMapping("/helloparam")
    public String getByQuestionMark(@PathParam("name") String name) {

        return "hello param "+name;
    }

    @RequestMapping("/test")
    public String GetConfig()
    {
    	return  envConfig.getTitle();
    }



}