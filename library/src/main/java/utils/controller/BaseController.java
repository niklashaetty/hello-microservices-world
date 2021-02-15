package utils.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {

    @Autowired
    private Tracer tracer;

    public <T> ResponseEntity<Map<String, Object>> ok(final T attributes) {

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("trace", tracer.currentSpan().context().traceId());
        body.put("attributes", attributes);

        return ResponseEntity
                .ok()
                .body(body);
    }

    public <T> ResponseEntity<Map<String, Object>> badRequest(final Error error) {

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("trace", tracer.currentSpan().context().traceId());
        body.put("error", error);

        return ResponseEntity
                .badRequest()
                .body(body);
    }

    public <T> ResponseEntity<Map<String, Object>> internalServerError(final Error error) {

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("trace", tracer.currentSpan().context().traceId());
        body.put("error", error);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(body);
    }

}
