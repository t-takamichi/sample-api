package com.example.applictiontraning.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JacksonXmlRootElement
public class ProductListResponse {
    @JacksonXmlElementWrapper(localName = "productList")
    @JacksonXmlProperty(localName = "product")
    private List<Product> productList;
}
