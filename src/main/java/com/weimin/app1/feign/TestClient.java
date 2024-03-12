package com.weimin.app1.feign;

import com.weimin.app1.config.FeignSupportConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "app1-service",configuration = FeignSupportConfig.class)
public interface TestClient {

    @GetMapping("/app1")
    String test1();

    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestPart("file") MultipartFile file);

    @PostMapping(value = "/upload2",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload2(@RequestPart("files") MultipartFile[] files);
}
