package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.Greeting;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Class       : UserController
 * Author      : 조 준 희
 * Description : Class Description
 * History     : [2022-06-13] - 조 준희 - Class Create
 */
@RestController
@RequestMapping(value = "/")
public class UserController {

    private Environment env;
    private UserService userService;
    private Greeting greeting;

    @Autowired
    public UserController(Environment env, UserService userService, Greeting greeting) {
        this.env = env;
        this.userService = userService;
        this.greeting = greeting;
    }

    @Autowired

    @GetMapping("/heath_check")
    public String status(){
        return "It's Working in User Service.";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return env.getProperty("greeting.message") + greeting.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user){

        UserDto userDto = UserDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .pwd(user.getPwd())
                .build();

        userService.createUser(userDto);

        ResponseUser responseUser = ResponseUser.builder()
                .userId(userDto.getUserId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();

        return new ResponseEntity<ResponseUser>(responseUser,HttpStatus.CREATED);

    }

}
