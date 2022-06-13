package com.example.userservice.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class       : RequestUser
 * Author      : 조 준 희
 * Description : Class Description
 * History     : [2022-06-13] - 조 준희 - Class Create
 */
@Data
public class RequestUser {
    @NotNull(message = "Email connot be null")
    @Size(min = 2, message= "Email not be less than two charactors")
    @Email
    private String email;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name not be less than two charactors")
    private String name;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be less than two charactors")
    private String pwd;
}
