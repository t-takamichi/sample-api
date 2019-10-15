package com.example.applictiontraning.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductPostRequest {
    private String productName;
    private Integer unitPrice;
}
