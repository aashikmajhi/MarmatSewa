package com.example.marmatsewa.Registration.LoginDevelopment;

public class LoginResponse {

    private String status;
    private String token;
    private String role;
    private String user_id;

    public LoginResponse(String status, String token, String role, String user_id) {
        this.status = status;
        this.token = token;
        this.role = role;
        this.user_id = user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
