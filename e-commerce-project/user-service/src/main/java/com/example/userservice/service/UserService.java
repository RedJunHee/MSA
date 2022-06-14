package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.jpa.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Class       : UserSerivce
 * Author      : 조 준 희
 * Description : Class Description
 * History     : [2022-06-13] - 조 준희 - Class Create
 */
public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);

    Iterable<UserEntity> getUserByAll();

    UserDto getUserDetailsByEmail(String userName);
}
