package com.example.applictiontraning.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {
    private Integer productId;
    private String productName;
    private Integer unitPrice;
}
