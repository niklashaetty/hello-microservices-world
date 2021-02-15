package se.hello.services.helloworld.application.controller;

import utils.controller.Error;

public class ErrorMapper {

    public static Error badNameError(final String name) {
        return Error
                .builder(4000)
                .message(name + " is a bad name")
                .build();
    }
}
