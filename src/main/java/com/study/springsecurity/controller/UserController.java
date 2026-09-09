package com.study.springsecurity.controller;


import com.study.springsecurity.model.Users;
import com.study.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public Users createUser(@RequestBody Users users){

        return userService.save(users);
//        return users;
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
//        System.out.println(user);
       return userService.verify(user);
    }

    @GetMapping("/person")
    public String test(){
        return "machong paul";
    }
}
