package com.example.applictiontraning.service;

import com.example.applictiontraning.response.CatResponse;
import org.springframework.stereotype.Service;

@Service
public class CatService {
    public CatResponse findById(Integer id){
        CatResponse catResponse = CatResponse.builder().name("ナルト").age("4").bath("2017/10/22").build();
        return catResponse;
    }
}
