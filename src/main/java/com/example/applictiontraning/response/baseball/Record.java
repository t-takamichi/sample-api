package com.example.applictiontraning.response.baseball;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Record {


    @JsonProperty("順位")
//    @JacksonXmlProperty(localName = "順位")
    private Integer ranking;
    @JsonProperty("氏名")
//    @JacksonXmlProperty(localName = "氏名")
    private String namep;
//    @JacksonXmlProperty(localName = "本数")
    @JsonProperty("本数")
    private Integer numberOfBaseball;

}
