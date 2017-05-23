package com.qodr.lapakbekas.entity;

/**
 * Created by kodeartisan on 14/05/17.
 */
public class User {

    private String userId;
    private String userName;
    private boolean confirmed;
    private String token;
    private String email;
    private String omnikey;
    private String message;

    public User(String userId, String userName, boolean confirmed, String token, String email, String omnikey, String message) {
        this.userId = userId;
        this.userName = userName;
        this.confirmed = confirmed;
        this.token = token;
        this.email = email;
        this.omnikey = omnikey;
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOmnikey() {
        return omnikey;
    }

    public void setOmnikey(String omnikey) {
        this.omnikey = omnikey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
