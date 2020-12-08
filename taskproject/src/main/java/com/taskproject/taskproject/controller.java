package com.taskproject.taskproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class controller {

    @GetMapping("/all")
    public String  show() {
        return "hello test";
    }
}