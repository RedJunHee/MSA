package com.example.userservice.jpa;

import org.springframework.data.repository.CrudRepository;

/**
 * Class       : UserRepository
 * Author      : 조 준 희
 * Description : Class Description
 * History     : [2022-06-13] - 조 준희 - Class Create
 */
public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
