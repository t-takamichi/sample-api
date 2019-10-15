package com.example.applictiontraning.object;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductObject {
    private Integer productId;
    private String productName;
    private Integer unitPrice;
}
