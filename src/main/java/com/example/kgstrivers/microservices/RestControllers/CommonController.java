package com.example.kgstrivers.microservices.RestControllers;

import com.example.kgstrivers.microservices.Models.User;
import com.example.kgstrivers.microservices.Repository.UserRepo;
import com.example.kgstrivers.microservices.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommonController {


    @Autowired
    UserService userService;

    @GetMapping("/welcome")
    public String welcome()
    {
        return "welcome";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/logout")
    public String logout()
    {
        return "logout";
    }


    @GetMapping("/user/{name}")
    public User about(@PathVariable String name)
    {

        return userService.findByUserID(name);
    }

    @PostMapping("/save")
    @ResponseBody
    public User saveData(@RequestBody User user)
    {
        return userService.save(user);
    }
}
