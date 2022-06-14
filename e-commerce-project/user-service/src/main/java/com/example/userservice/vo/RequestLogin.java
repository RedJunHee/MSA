package com.example.userservice.vo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class       : RequestLogin
 * Author      : 조 준 희
 * Description : Class Description
 * History     : [2022-06-14] - 조 준희 - Class Create
 */
@Data
public class RequestLogin {
    @NotNull
    @Size(min = 2, message = "Email not be less than two characters")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be equals or grater than 8 characters")
    private String password;
}