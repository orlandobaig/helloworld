package com.example.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class HelloWorldController {

    @GetMapping("/greet-get")
    public String greetGet(@RequestParam(required = false) String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Debes escribir un nombre.";
        }
        return "¡Bienvenido a mi aplicación, " + name + "!";
    }

    @PostMapping("/greet-post")
    public String greetPost(@RequestParam(required = false) String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Debes escribir un nombre.";
        }
        return "¡Bienvenido a mi aplicación, " + name + "!";
    }

    @PostMapping("/greet-json")
    public GreetingResponse greetJson(@RequestBody UserInput input) {
        String name = input.getName();
        String message;

        if (name == null || name.trim().isEmpty()) {
            message = "Debes escribir un nombre.";
        } else {
            message = "¡Bienvenido a mi aplicación (JSON), " + name + "!";
        }

        // Spring will auto-convert this object into JSON
        return new GreetingResponse(message);
    }
}