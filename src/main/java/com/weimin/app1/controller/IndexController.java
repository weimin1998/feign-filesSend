package com.weimin.app1.controller;

import com.weimin.app1.feign.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class IndexController {

    @Autowired
    TestClient testClient;
    @GetMapping("/hello")
    public String test(){
        return testClient.test1();
    }


    @PostMapping(value = "/aaaaa")
    public String aaaaa(MultipartFile file){
        return testClient.upload(file);
    }

    @PostMapping(value = "/bbbbb")
    public String bbbbb(MultipartFile[] files){
        return testClient.upload2(files);
    }

}
