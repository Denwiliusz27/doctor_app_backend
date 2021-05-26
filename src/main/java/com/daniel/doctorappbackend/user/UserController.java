package com.daniel.doctorappbackend.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uzytkownicy")
public class UserController {
    public UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/wszyscy")
    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    @GetMapping("id/{userId}")
    public Optional<User> getUserById(@PathVariable long userId){
        return userDao.findById(userId);
    }
}
