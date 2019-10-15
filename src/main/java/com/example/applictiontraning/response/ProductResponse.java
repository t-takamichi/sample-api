package com.example.applictiontraning.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JacksonXmlRootElement
public class ProductResponse {
    @JacksonXmlProperty(localName = "product")
    private Product product;
}
