package com.hawaso.javacampus.models.identity;

import jakarta.validation.constraints.NotBlank;

public class LoginInputModel {
    @NotBlank(message = "사용자 이름을 입력하세요.")
    private String userName;

    @NotBlank(message = "비밀번호를 입력하세요.")
    private String password;

    private boolean rememberMe;

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public boolean isRememberMe() { return rememberMe; }
    public void setRememberMe(boolean rememberMe) { this.rememberMe = rememberMe; }
}
