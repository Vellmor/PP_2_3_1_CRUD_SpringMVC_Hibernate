package ru.kata.springmvcapp.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PoliteController {
    @GetMapping("hello")
    public String hello() {
        return "polite/hello";
    }

    @GetMapping("goodbye")
    public String goodBye() {
        return "polite/goodbye";
    }
}
