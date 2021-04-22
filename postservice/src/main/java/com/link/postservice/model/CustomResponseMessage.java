package com.link.postservice.model;

public class CustomResponseMessage {
    private String message ;

    public CustomResponseMessage() {
    }

    public CustomResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CustomResponseMessage{" +
                "message='" + message + '\'' +
                '}';
    }

}
