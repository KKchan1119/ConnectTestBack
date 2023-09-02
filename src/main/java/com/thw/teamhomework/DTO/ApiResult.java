package com.thw.teamhomework.DTO;

public class ApiResult {
    private String code;
    private String message;
    private Object body;

    public void setToken(String token) {
    }

    public ApiResult() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
