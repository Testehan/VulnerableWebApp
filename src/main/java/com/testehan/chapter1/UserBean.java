package com.testehan.chapter1;

import java.io.Serializable;


public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String roles = "";

    public UserBean(String u, String r){
        this.username = u;
        this.roles = r;
    }

    public String getUsername() {
        return username;
    }

    public String getRoles() {
        return roles;
    }
}
