package se.hello.services.helloworld.application.beans;

public class Greeting {

    private final String name;

    public Greeting(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}