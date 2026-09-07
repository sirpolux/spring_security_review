package com.study.springsecurity.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/v1/inventory")
public class TestController {
    @GetMapping("/")
    public String test(HttpServletRequest httpServletRequest){
        return "Connection Successful " + httpServletRequest.getSession().getId();
    }
}
