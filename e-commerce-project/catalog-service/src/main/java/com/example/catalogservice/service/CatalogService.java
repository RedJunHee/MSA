package com.example.catalogservice.service;

import com.example.catalogservice.jpa.CatalogEntity;

/**
 * Class       : CatalogService
 * Author      : 조 준 희
 * Description : Class Description
 * History     : [2022-06-13] - 조 준희 - Class Create
 */
public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}