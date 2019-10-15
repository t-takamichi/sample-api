package com.example.applictiontraning.repository;

import com.example.applictiontraning.entity.ProductEntity;
import com.example.applictiontraning.response.Product;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

    @NonNull
    private final ProductJpaRepository productJpaRepository;

    public List<Product> findProductAll() {
        return productJpaRepository.findAll(Sort.by("productId"))
                .stream()
                .filter(Objects::nonNull)
                .map(ProductEntity::toProduct).collect(Collectors.toList());
    }

    public Product findByProductId(Integer productId) throws RuntimeException {
        return productJpaRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException(productId + " is not found."))
                .toProduct();
    }

    public void deleteByProductId(Integer productId) {
        productJpaRepository.deleteById(productId);
    }

    public Product saveOrUpdate(Product product) {
        ProductEntity entity = new ProductEntity();

        if (product.getProductId() != null) {
            entity.setProductId(product.getProductId());
        }
        entity.setProductName(product.getProductName());
        entity.setUnitPrice(product.getUnitPrice());
        return productJpaRepository
                .save(entity)
                .toProduct();
    }


}
