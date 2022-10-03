package com.example.rest_user_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class RestUserStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestUserStoreApplication.class, args);
    }

}

