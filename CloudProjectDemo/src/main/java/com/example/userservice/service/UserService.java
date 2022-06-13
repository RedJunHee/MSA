package com.example.userservice.service;

import com.example.userservice.dto.UserDto;

/**
 * Class       : UserSerivce
 * Author      : 조 준 희
 * Description : Class Description
 * History     : [2022-06-13] - 조 준희 - Class Create
 */
public interface UserService {
    UserDto createUser(UserDto userDto);

}
