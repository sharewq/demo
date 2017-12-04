package com.RabbitMq.Model;

import java.io.Serializable;

/**
 * Created by Think on 2017/7/25.
 */
public class User implements Serializable {

    private Long id;
    private String name;

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

    @Override
    public String toString() {
        return String.format("User{id=%d, name=%s}", id, name);
    }
}