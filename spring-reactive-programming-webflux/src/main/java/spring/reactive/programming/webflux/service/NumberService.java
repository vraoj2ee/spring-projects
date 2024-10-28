package spring.reactive.programming.webflux.service;

import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring.reactive.programming.webflux.entity.Number;

public interface NumberService {

    Flux<Number> getAllNumbers();
    public Mono<Number> addNumber(Number number);
}
