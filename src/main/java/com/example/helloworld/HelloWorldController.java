package com.example.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String showForm() {
        return """
                    <body style='background-color:black; color:white; font-family:sans-serif; padding:20px;'>
                        <h2>Usando el método GET</h2>
                        <form action="/greet-get" method="get">
                            <label>&iquest;Cuál es tu nombre&#63;</label><br>
                            <input type="text" name="name" required>
                            <button type="submit">Enviar por GET</button>
                        </form>

                        <br><br><hr><br>

                        <h2>Usando el método POST</h2>
                        <form action="/greet-post" method="post">
                            <label>&iquest;Cuál es tu nombre&#63;</label><br>
                            <input type="text" name="name" required>
                            <button type="submit">Enviar por POST</button>
                        </form>
                    </body>
                """;
    }

    @GetMapping("/greet-get")
    public String greet(@RequestParam(required = false) String name) {
        if (name == null || name.trim().isEmpty()) {
            return """
                        <body style='background-color:black; color:white; font-family:sans-serif; padding:20px;'>
                            Debes escribir un nombre. <a href='/'>Regresar</a>
                        </body>
                    """;
        }
        return String.format("""
                    <body style='background-color:black; color:white; font-family:sans-serif; padding:20px;'>
                        ¡Bienvenido a mi aplicación, %s!
                    </body>
                """, name);
    }

    @PostMapping("/greet-post")
    public String greetPost(@RequestParam(required = false) String name) {
        if (name == null || name.trim().isEmpty()) {
            return """
                        <body style='background-color:black; color:white; font-family:sans-serif; padding:20px;'>
                            Debes escribir un nombre. <a href='/'>Regresar</a>
                        </body>
                    """;
        }
        return String.format("""
                    <body style='background-color:black; color:white; font-family:sans-serif; padding:20px;'>
                        ¡Bienvenido a mi aplicación, %s!
                    </body>
                """, name);
    }
}
