package utils.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    public <T> ResponseEntity<T> ok(final T attributes) {
        return new ResponseEntity(attributes, HttpStatus.OK);
    }
}
