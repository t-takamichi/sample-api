package com.example.applictiontraning.controller;

import com.example.applictiontraning.response.baseball.BaseballResponse;
import com.example.applictiontraning.service.BaseBallService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1/baseball/")
@RequiredArgsConstructor
public class BaseBallController {

    @NonNull private BaseBallService baseBallService;

    @RequestMapping(value = "/list", method = RequestMethod.GET,  produces = { "application/json","application/xml", "text/xml" }, consumes = MediaType.ALL_VALUE)
    public BaseballResponse getProductList(@ApiIgnore @RequestHeader("accept") String accept){
        return baseBallService.getPopularHomeRunPlayer(accept);
    }
}
