package com.example.applictiontraning.service;

import com.example.applictiontraning.response.baseball.BaseballResponse;
import com.example.applictiontraning.response.baseball.DataResponse;
import com.example.applictiontraning.response.baseball.Record;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.awt.*;
import java.util.List;

@Service
public class BaseBallService {
    public BaseballResponse getPopularHomeRunPlayer(String accept){

        List<Record> recordList = List.of(
                Record.builder().ranking(1).namep("王貞治").numberOfBaseball(868).build(),
                Record.builder().ranking(2).namep("野村克也").numberOfBaseball(657).build(),
                Record.builder().ranking(3).namep("門田博光").numberOfBaseball(567).build(),
                Record.builder().ranking(4).namep("山本浩二").numberOfBaseball(536).build(),
                Record.builder().ranking(5).namep("清原和博").numberOfBaseball(525).build()
        );
        DataResponse dataResponse = DataResponse.builder().record(recordList).build();
        if(!accept.contains("application/json")){
            dataResponse.setName("ホームラン");
        }
        return BaseballResponse.builder().data(dataResponse).build();
    }
}
