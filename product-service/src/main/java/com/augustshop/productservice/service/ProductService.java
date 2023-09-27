package com.augustshop.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.augustshop.productservice.DTOs.ProductRequest;
import com.augustshop.productservice.DTOs.ProductResponse;
import com.augustshop.productservice.models.Product;
import com.augustshop.productservice.repository.ProductRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
            .name(productRequest.getName())
            .description(productRequest.getDescription())
            .price(productRequest.getPrice())
            .build();

        productRepo.save(product);

        log.info("Product {} with name {} is saved", product.getId(), product.getName());
    }

    public List<ProductResponse> getProducts() {

        List<Product> products = productRepo.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .build();
    }
    
}
