package com.it;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

@SpringBootApplication
public class ResourcesApplication extends WebMvcConfigurerAdapter {

    @Value("${web.path}")
    private String path;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        if (!(new File(path).exists())){
            try {
                throw new Exception("配置的静态文件目录不存在，请配置web.path为对应路径");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        registry.addResourceHandler("/temporarily/**").addResourceLocations(
                "file:"+path);

    }

    public static void main(String[] args) {
        SpringApplication.run(ResourcesApplication.class, args);
    }

}
