package com.example.applictiontraning.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private Integer productId;
    private String productName;
    private int unitPrice;
}
