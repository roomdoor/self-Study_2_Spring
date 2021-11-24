package com.example.chapter10.naver;

import com.example.chapter10.naver.dto.SearchImageReq;
import com.example.chapter10.naver.dto.SearchLocalReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NaverClientTest {

    @Autowired
    private NaverClient naverClient;

    @Test
    public void localSearchTest() {

        var req = new SearchLocalReq();
        req.setQuery("떡볶이");
        var result = naverClient.searchLocal(req);

        System.out.println(result);
    }

    @Test
    public void imageSearchTest() {

        var req = new SearchImageReq();
        req.setQuery("떡볶이");
        var result = naverClient.searchImage(req);

        System.out.println(result);
    }

}
