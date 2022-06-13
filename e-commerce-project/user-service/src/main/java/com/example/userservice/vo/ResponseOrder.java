package com.example.userservice.vo;

import lombok.*;

import java.util.Date;

/**
 * Class       : ResponseOrder
 * Author      : 조 준 희
 * Description : Class Description
 * History     : [2022-06-13] - 조 준희 - Class Create
 */
@Data
public class ResponseOrder {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private Date createAt;

    private  String orderId;

}
