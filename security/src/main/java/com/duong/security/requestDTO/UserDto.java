package com.duong.security.requestDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class UserDto {
    @NotBlank(message = "ten nguoi dung khong duoc de trong")
    private String name;
    @NotBlank(message = "email khong duoc bo trong")
    @Email(message = "email khong dung dinh dang")
    private String email;
    @NotBlank(message = "khong duoc bo trong mat khau")
    @Size(min = 6, message = "mat khau toi thieu phai co 6 ki tu")
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
