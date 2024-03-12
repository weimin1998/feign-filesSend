package com.weimin.app1.config;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Type;
import java.util.Map;

import static java.util.Collections.singletonMap;

public class MyEncoder extends SpringFormEncoder {

    public MyEncoder(SpringEncoder springEncoder) {
        super(springEncoder);
    }

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        if(bodyType.equals(MultipartFile.class)) {
            MultipartFile file = (MultipartFile)object;
            Map<String, Object> data = singletonMap(file.getName(), object);
            super.encode(data, MAP_STRING_WILDCARD, template);
        }else if (bodyType.equals(MultipartFile[].class)) {
            // MultipartFile数组处理
            MultipartFile [] file = (MultipartFile[]) object;
            if (file != null) {
                Map<String, Object> data = singletonMap(file.length == 0 ? "" : file[0].getName(), object);
                super.encode(data, MAP_STRING_WILDCARD, template);
            }
        } else {
            super.encode(object, bodyType, template);
        }
    }
}
