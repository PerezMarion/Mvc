package com.example.demoThymeleaf.business;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HelloService {

    public String sayHello() {
        return "Bonjour Marion !";
    }

    public String sayTime() {
        return LocalDateTime.now().toString();
    }
}