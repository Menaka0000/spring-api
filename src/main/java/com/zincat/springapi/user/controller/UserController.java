package com.zincat.springapi.user.controller;

import com.zincat.springapi.common.entity.User;
import com.zincat.springapi.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(params = {"id"})
    public User getUserById(Long id) {
        System.out.println("i'm in user");
        return userService.findUserById(id);
    }

    @GetMapping("/test")
    public String test() {
        return "test passed";
    }

}
