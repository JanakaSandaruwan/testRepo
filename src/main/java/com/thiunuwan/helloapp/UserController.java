package com.thiunuwan.helloapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/demo")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path ="/add")
    public @ResponseBody User addNewUser(@RequestParam String name,@RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}
