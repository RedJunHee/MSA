package com.example.catalogservice.jpa;

import org.springframework.data.repository.CrudRepository;

/**
 * Class       : CatalogRepository
 * Author      : 조 준 희
 * Description : Class Description
 * History     : [2022-06-13] - 조 준희 - Class Create
 */
public interface CatalogRepository extends CrudRepository<CatalogEntity, Long> {
    CatalogEntity findByProductId(String productId);
}
