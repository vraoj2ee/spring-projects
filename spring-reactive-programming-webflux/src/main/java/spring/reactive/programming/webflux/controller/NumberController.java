package spring.reactive.programming.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring.reactive.programming.webflux.entity.Number;
import spring.reactive.programming.webflux.service.NumberService;

@RestController
@RequestMapping("/numbers")
public class NumberController {

    @Autowired
    private NumberService numberService;

    @GetMapping
    public Flux<Number> getAllNumbers() {
        return numberService.getAllNumbers();
    }

    @PostMapping
    public Mono<Number> addNumber(@RequestBody Number number) {
        return numberService.addNumber(number);
    }
}
