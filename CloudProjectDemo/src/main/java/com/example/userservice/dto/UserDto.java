package com.example.userservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Class       : UserDto
 * Author      : 조 준 희
 * Description : Class Description
 * History     : [2022-06-13] - 조 준희 - Class Create
 */
@Data
@Builder
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createAt;

    private String encryptedPwd;
}
