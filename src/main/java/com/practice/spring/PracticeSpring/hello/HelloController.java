package com.practice.spring.PracticeSpring.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHi(){
        return "hi";
    }

}
//@RestController lets Spring know that this class is a controller for urls mapping
//@RequestMapping is used to map the class to the url to access it in browser
//@RequestMapping only give GET method as a default return for other HTTP mapping we need to configure it with their annotations
