package com.epam.DBController.Entities;

/**
 * Created by vrama on 16.04.2016.
 */
public class Socials {
    private Long id;
    private String name;

    public Socials(String name) {
        this.name = name;
    }

    public Socials(Long id) {
        this.id = id;
    }

    public Socials(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
