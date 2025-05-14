package com.example.helloworld;

public class GreetingResponse {
    private String message;

    // Constructor
    public GreetingResponse(String message) {
        this.message = message;
    }

    // Getter
    public String getMessage() {
        return message;
    }

    // Setter
    public void setMessage(String message) {
        this.message = message;
    }
}
