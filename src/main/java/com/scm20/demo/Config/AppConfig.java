package com.scm20.demo.Config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class AppConfig {
    @Value("${cloudinary.cloud.name}")
    private String cloudName;
    @Value("${cloudinary.api.key}")
    private String api;
    @Value("${cloudinary.api.secret}")
    private String secret;

    @Bean
    ModelMapper getModelMapper(){return new ModelMapper();}

    @Bean
    public Cloudinary getCloudinary(){
        return new Cloudinary(
                ObjectUtils.asMap("cloud_name",cloudName,"api_key",api,"api_secret",secret)
        );
    }
}
