package com.testehan.chapter1;

public enum Roles {
    ADMIN,
    USER;


    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}

