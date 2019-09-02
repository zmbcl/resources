package com.it.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Random;

@RestController
public class DemoController {

    @RequestMapping(value = "/hello")
    public void test() throws IOException {
        Random random = new Random(100);
        int name = random.nextInt();
//        double fileName = Math.random()*50;
        String file = "/Users/bcl/temporarily/"+name+".html";
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><title>Title</title></head><body>你好！！</body></html>");
        fileWriter.flush();
        fileWriter.close();
        System.out.println(name+".html");

    }
}
