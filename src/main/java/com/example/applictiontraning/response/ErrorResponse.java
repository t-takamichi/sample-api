package com.example.applictiontraning.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String errorCode;
    private String description;
}
