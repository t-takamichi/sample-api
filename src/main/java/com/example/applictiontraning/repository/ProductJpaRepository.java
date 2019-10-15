package com.example.applictiontraning.repository;

import com.example.applictiontraning.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity,Integer> {
    ProductEntity save(ProductEntity entity);
}
