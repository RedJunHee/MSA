package com.example.userservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

/**
 * Class       : ResponseUser
 * Author      : 조 준 희
 * Description : Class Description
 * History     : [2022-06-13] - 조 준희 - Class Create
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUser {
    private String email;
    private String name;
    private String userId;

    private List<ResponseOrder> orders;

}
