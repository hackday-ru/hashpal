package com.epam.DBController.Entities;

//import com.sun.tools.corba.se.idl.constExpr.Times;

import java.sql.Timestamp;

/**
 * Created on 16/04/16.
 *
 * @author Vladislav Boboshko
 */
public class Post {
    Long id;
    Long socialId;
    String postId;
    String hashtags;
    Timestamp time;
    Double lat;
    Double lon;

    public Post(Long socialId, String postId, String hashtags, Timestamp time, Double lat, Double lon) {
        this.socialId = socialId;
        this.postId = postId;
        this.hashtags = hashtags;
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public Post(Long id, Long socialId, String postId, String hashtags, Timestamp time, Double lat, Double lon) {

        this.id = id;
        this.socialId = socialId;
        this.postId = postId;
        this.hashtags = hashtags;
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public Long getSocialId() {
        return socialId;
    }

    public void setSocialId(Long socialId) {
        this.socialId = socialId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getHashtags() {
        return hashtags;
    }

    public void setHashtags(String hashtags) {
        this.hashtags = hashtags;
    }
}
