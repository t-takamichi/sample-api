package com.example.applictiontraning.controller;

import com.example.applictiontraning.response.CatResponse;
import com.example.applictiontraning.service.CatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cat/")
@RequiredArgsConstructor
@Api(tags = "このエンドポイントは、猫情報操作用",description = "The endpoint is Cat Information.")
public class CatController {

    @NonNull private CatService catService;

    @ApiOperation(value = "Idを元に猫の情報を返します。")
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CatResponse findByCat(@PathVariable Integer id) {
        return catService.findById(id);
    }
    @RequestMapping(value = "name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String findByCat2(@PathVariable String name) {
        return name;
    }
}
