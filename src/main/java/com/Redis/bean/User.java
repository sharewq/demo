package com.Redis.bean;

import java.io.Serializable;

/**
 * Created by Think on 2017/10/30.
 */
public class User implements Serializable {
    public String id;
    public String name;
    public String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
