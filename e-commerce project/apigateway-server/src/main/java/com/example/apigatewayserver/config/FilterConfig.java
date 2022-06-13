package com.example.apigatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class       : FilterConfig
 * Author      : 조 준 희
 * Description : Class Description
 * History     : [2022-06-10] - 조 준희 - Class Create
 */
//@Configuration
public class FilterConfig {


//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes().route(r -> r.path("/first-service/**")
                                                .filters(f -> f.addRequestHeader("first-request","first-request-header" ) // key, value 형식
                                                        .addResponseHeader("first-response","first-response-header") )
                                                .uri("http://localhost:8081/"))
                                .route(r -> r.path("/second-service/**")
                                        .filters(f -> f.addRequestHeader("second-request","second-request-header" ) // key, value 형식
                                                .addResponseHeader("second-response","second-response-header") )
                                        .uri("http://localhost:8082/"))
                .build();

    }
}
