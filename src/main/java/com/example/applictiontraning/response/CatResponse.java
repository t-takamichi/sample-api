package com.example.applictiontraning.response;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatResponse {
    private String name;
    private String age;
    private String bath;
}
