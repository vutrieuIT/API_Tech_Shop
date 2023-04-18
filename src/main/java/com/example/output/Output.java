package com.example.output;

import java.util.ArrayList;
import java.util.List;

public class Output<T> {
    private String error = "false";
    private String message = "thanh cong";
    private List<T> data = new ArrayList<T>();
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(T data){
        this.data.add(data);
    }
    public void setData(List<T> data) {
        this.data = data;
    }



}
