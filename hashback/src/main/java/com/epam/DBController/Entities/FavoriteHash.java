package com.epam.DBController.Entities;

/**
 * Created by vrama on 16.04.2016.
 */
public class FavoriteHash {

    private Long id;
    private Long userId;
    private String hashtag;

    public FavoriteHash(Long userId, String hashtag) {
        this.userId = userId;
        this.hashtag = hashtag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }
}
