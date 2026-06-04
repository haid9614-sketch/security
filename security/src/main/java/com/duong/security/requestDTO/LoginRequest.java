package com.duong.security.requestDTO;

public class LoginRequest {
    private String usernName;
    private String password;

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsernName() {
        return usernName;
    }
    public void setUsernName(String usernName) {
        this.usernName = usernName;
    }
}
