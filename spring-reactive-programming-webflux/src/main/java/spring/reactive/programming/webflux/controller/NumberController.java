package spring.reactive.programming.webflux.controller;

import spring.reactive.programming.webflux.entity.Number;
import spring.reactive.programming.webflux.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/numbers")
public class NumberController {

    @Autowired
    private NumberRepository numberRepository;

    @GetMapping
    public Flux<Number> getAllNumbers() {
        return numberRepository.findAll();
    }

    @PostMapping
    public Mono<Number> addNumber(@RequestBody Number number) {
        return numberRepository.save(number);
    }
}
