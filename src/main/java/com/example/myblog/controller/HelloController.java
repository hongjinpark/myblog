package com.example.myblog.controller;


import com.example.myblog.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

   @GetMapping("/hello")
   public String helloController() {
        return "hello World!";
   }

   @GetMapping("/hello/dto")
    public HelloResponseDto helloResponseDto(@RequestParam String name, @RequestParam String nickname) {
       return new HelloResponseDto(name, nickname);
   }
}
