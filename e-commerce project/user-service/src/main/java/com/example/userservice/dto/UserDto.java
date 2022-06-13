package com.example.userservice.dto;

import com.example.userservice.vo.ResponseOrder;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Class       : UserDto
 * Author      : 조 준 희
 * Description : Class Description
 * History     : [2022-06-13] - 조 준희 - Class Create
 */
@Data
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createAt;

    private String encryptedPwd;

    private List<ResponseOrder> orders;
}
