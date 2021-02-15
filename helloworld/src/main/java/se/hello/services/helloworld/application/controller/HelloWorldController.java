package se.hello.services.helloworld.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;
import se.hello.services.helloworld.application.beans.Greeting;
import utils.controller.BaseController;

@Controller
public class HelloWorldController extends BaseController {

    final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping("/greeting")
    public Mono<ResponseEntity> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        if(name.equals("Niklas")) {
            log.info("Found bad name!");
            return Mono.just(
                    badRequest(ErrorMapper.badNameError(name)));
        }
        return Mono.just(
                ok(new Greeting(name)));
    }
}
