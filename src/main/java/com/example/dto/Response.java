package com.example.dto;

public class Response<T> {
    private boolean error = false;
    private String message = "thành công";
    private T data;

    // constructors, getters and setters

    public Response() {
    }

    public Response(boolean error, String message, T data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
