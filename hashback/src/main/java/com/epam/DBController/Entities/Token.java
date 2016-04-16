package com.epam.DBController.Entities;

/**
 * Created by vrama on 16.04.2016.
 */
public class Token {
    private Long userID, socID;
    private String token;


    public Token() {
    }


    public Token(Long userID, Long socID, String token) {
        this.userID = userID;
        this.socID = socID;
        this.token = token;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getSocID() {
        return socID;
    }

    public void setSocID(Long socID) {
        this.socID = socID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
