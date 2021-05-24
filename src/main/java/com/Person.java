package com;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

}
