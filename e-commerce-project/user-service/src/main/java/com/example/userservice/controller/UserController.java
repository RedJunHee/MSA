package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.jpa.UserEntity;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.Greeting;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class       : UserController
 * Author      : 조 준 희
 * Description : Class Description
 * History     : [2022-06-13] - 조 준희 - Class Create
 */
@RestController
@RequestMapping(value = "/")
@Slf4j
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
        return String.format("It's Working in User Service "
                + ", port(local.server.port) = " +env.getProperty("local.server.port")
                + ", port(server.port) = " +env.getProperty("server.port")
                + ", token secret = " +env.getProperty("token.secret")
                + ", token expiration_time = " +env.getProperty("token.expiration_time"));
    }

    @GetMapping("/welcome")
    public String welcome(){
        return env.getProperty("greeting.message") + greeting.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user){

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(user, UserDto.class);

        userService.createUser(userDto);

        ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);

        return new ResponseEntity<ResponseUser>(responseUser,HttpStatus.CREATED);

    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers(){
        Iterable<UserEntity> userList = userService.getUserByAll();

        List<ResponseUser> result = new ArrayList<>();

        userList.forEach(v -> {
            log.info("사용자 : {}",v.toString());
            result.add(new ModelMapper().map(v, ResponseUser.class));

        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUsers(@PathVariable(value = "userId") String userId){
        UserDto userDto = userService.getUserByUserId(userId);


        ResponseUser returnValue = new ModelMapper().map(userDto, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }

}
