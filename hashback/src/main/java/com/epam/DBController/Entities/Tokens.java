package com.epam.DBController.Entities;

/**
 * Created by vrama on 16.04.2016.
 */
public class Tokens {
    private Long user_id, soc_id;
    private String token;

    public Tokens(Long user_id, Long soc_id, String token) {
        this.user_id = user_id;
        this.soc_id = soc_id;
        this.token = token;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getSoc_id() {
        return soc_id;
    }

    public void setSoc_id(Long soc_id) {
        this.soc_id = soc_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
