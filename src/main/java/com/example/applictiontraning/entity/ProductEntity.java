package com.example.applictiontraning.entity;

import com.example.applictiontraning.response.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Table(name = "product")
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Data
@Builder
public class ProductEntity {

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name = "productId")
    private Integer productId;
    @Column(name = "productName")
    private String productName;
    @Column(name = "unitPrice")
    private Integer unitPrice;

    public Product toProduct(){
        return Product.builder()
                .productId(this.productId)
                .productName(this.productName)
                .unitPrice(this.unitPrice)
                .build();
    }
}
