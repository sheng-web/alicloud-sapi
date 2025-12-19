package com.tom.controller;

import com.tom.dao.User;
import com.tom.dao.UserDao;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController  {
//I'm back.
    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userDao.addUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userDao.findUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PutMapping("/{id}")
    public void updateUserById(@PathVariable long id, @RequestBody User updatedUser) {
        userDao.updateUserById(id, updatedUser);
    }



    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable long id) {
        userDao.deleteUserById(id);
    }
}
