package com.epam.DBController.Entities;

/**
 * Created by vrama on 16.04.2016.
 */
public class Social {
    private Long id;
    private String name;

    public Social(String name) {
        this.name = name;
    }

    public Social(Long id) {
        this.id = id;
    }

    public Social(String name, Long id) {
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
