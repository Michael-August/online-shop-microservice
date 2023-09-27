package com.augustshop.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.augustshop.productservice.models.Product;

public interface ProductRepo extends MongoRepository<Product, String> {
    
}
