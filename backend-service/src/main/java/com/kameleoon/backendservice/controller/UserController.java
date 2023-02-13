package com.kameleoon.backendservice.controller;

import com.kameleoon.backendservice.dto.UserDto;
import com.kameleoon.backendservice.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "This method is used to create user")
    @PostMapping
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        return userService.newUser(userDto);
    }
}
