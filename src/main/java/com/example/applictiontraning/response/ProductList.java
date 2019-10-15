package com.example.applictiontraning.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductList {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty
    @JsonUnwrapped(enabled = false)
    private List<Product> productList;
}
