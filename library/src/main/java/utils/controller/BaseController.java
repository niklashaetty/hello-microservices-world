package utils.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import utils.controller.beans.Error;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {

    @Autowired
    private Tracer tracer;

    final Logger log = LoggerFactory.getLogger(BaseController.class);

    public <T> ResponseEntity<Map<String, Object>> ok(final T attributes) {

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("trace", tracer.currentSpan().context().traceId());
        body.put("attributes", attributes);

        return response(ResponseEntity
                .ok()
                .body(body)
        );
    }

    public <T> ResponseEntity<Map<String, Object>> badRequest(final Error error) {

        Map<String, Object> body = new HashMap<>();
        body.put("trace", tracer.currentSpan().context().traceId());
        body.put("error", error);

        return response(ResponseEntity
                .badRequest()
                .body(body)
        );
    }

    public <T> ResponseEntity<Map<String, Object>> internalServerError(final Error error) {

        Map<String, Object> body = new HashMap<>();
        body.put("trace", tracer.currentSpan().context().traceId());
        body.put("error", error);

        return response(ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(body)
        );
    }

    private <T> ResponseEntity<Map<String, Object>> response(ResponseEntity<Map<String, Object>> response) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        log.info(response.getBody().toString());
        return response;
    }
}
