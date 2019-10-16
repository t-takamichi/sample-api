package com.example.applictiontraning.service;

import com.example.applictiontraning.exception.BadRequestException;
import com.example.applictiontraning.exception.DataNotFoundException;
import com.example.applictiontraning.repository.ProductRepository;
import com.example.applictiontraning.request.ProductPostRequest;
import com.example.applictiontraning.request.ProductRequest;
import com.example.applictiontraning.response.Product;
import com.example.applictiontraning.response.ProductListResponse;
import com.example.applictiontraning.response.ProductResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    @NonNull
    private ProductRepository productRepository;

    public ProductListResponse getProductAll() {
        ProductListResponse productListResponse = ProductListResponse.builder()
                .productList(productRepository.findProductAll())
                .build();
        return productListResponse;
    }

    public ProductResponse findByProductId(Integer productId) throws Exception {
        Product product = null;
        try {
            product = productRepository.findByProductId(productId);
        } catch (RuntimeException e) {
            throw new DataNotFoundException(e.getMessage());
        }

        ProductResponse productResponse = ProductResponse.builder().product(product).build();
        return productResponse;
    }
    @Transactional
    public ProductResponse update(ProductRequest productRequest) throws Exception {

        if (Objects.isNull(productRequest.getProductName()) && Objects.isNull(productRequest.getUnitPrice())
                && Objects.isNull(productRequest.getProductId())) {
            // BAD REQUEST
            throw  new BadRequestException("invalid request parameter");
        }
        Product product = Product.builder()
                .productId(productRequest.getProductId())
                .productName(productRequest.getProductName())
                .unitPrice(productRequest.getUnitPrice())
                .build();

        product = productRepository.saveOrUpdate(product);


        ProductResponse productResponse = ProductResponse.builder().product(product).build();
        return productResponse;
    }

    @Transactional
    public ProductResponse save(ProductPostRequest productPostRequest) throws Exception {

        if(Objects.isNull(productPostRequest.getProductName()) && Objects.isNull(productPostRequest.getUnitPrice() )){
            // BAD REQUEST
            throw new BadRequestException("invalid request parameter");
        }
        Product product = Product.builder()
                .productName(productPostRequest.getProductName())
                .unitPrice(productPostRequest.getUnitPrice())
                .build();

        product = productRepository.saveOrUpdate(product);

        ProductResponse productResponse = ProductResponse.builder().product(product).build();
        return productResponse;
    }

    @Transactional
    public void delete(Integer productId) throws Exception {
        Product product = null;
        try {
            product = productRepository.findByProductId(productId);
        } catch (RuntimeException e) {
            throw new DataNotFoundException(e.getMessage());
        }
        productRepository.deleteByProductId(product.getProductId());
    }
}
