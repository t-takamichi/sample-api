package com.example.applictiontraning.controller;

import com.example.applictiontraning.request.ProductPostRequest;
import com.example.applictiontraning.request.ProductRequest;
import com.example.applictiontraning.response.ProductListResponse;
import com.example.applictiontraning.response.ProductResponse;
import com.example.applictiontraning.service.ProductService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    @NonNull
    private ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {"application/json", "application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
    public ProductListResponse getProductList() {
        return productService.getProductAll();
    }


    @RequestMapping(value = "/{productId}", method = RequestMethod.GET, produces = {"application/json", "application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
    public ProductResponse findByProductId(@PathVariable Integer productId) throws Exception {
        return productService.findByProductId(productId);
    }

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json", "application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
    public ProductResponse saveProduct(@RequestBody ProductPostRequest productPostRequest) throws Exception {
        return productService.save(productPostRequest);
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.PUT, produces = {"application/json", "application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
    public ProductResponse updateProduct(@PathVariable Integer productId, @RequestBody ProductRequest productRequest) throws Exception {
        return productService.update(productRequest);
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE, produces = {"application/json", "application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
    public void deleteByProductId(@PathVariable Integer productId) throws Exception {
        productService.delete(productId);
    }


}
