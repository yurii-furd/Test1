package com;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private String name;

    @JsonProperty("message ")
    public String getMessage() {
        return "Привіт, " + name + "!";
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
