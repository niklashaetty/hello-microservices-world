package se.hello.services.helloworld.application.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {

    @JsonProperty("name")
    private final String name;

    public Greeting(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "name='" + name + '\'' +
                '}';
    }
}