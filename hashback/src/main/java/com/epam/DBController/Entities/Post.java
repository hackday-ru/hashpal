package com.epam.DBController.Entities;

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

    public Post(Long socialId, String postId, String hashtags) {
        this.socialId = socialId;
        this.postId = postId;
        this.hashtags = hashtags;
    }

    public Post(Long id, Long socialId, String postId, String hashtags) {
        this.id = id;
        this.socialId = socialId;
        this.postId = postId;
        this.hashtags = hashtags;
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
