package com.example.applictiontraning.response.baseball;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JacksonXmlRootElement
public class BaseballResponse {
    @JacksonXmlProperty(localName = "data")
    private DataResponse data;
}
