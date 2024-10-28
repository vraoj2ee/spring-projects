package spring.reactive.programming.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring.reactive.programming.webflux.entity.Number;
import spring.reactive.programming.webflux.repository.NumberRepository;

@Service
public class NumberServiceImpl implements NumberService {

    @Autowired
    private NumberRepository numberRepository;

    @Override
    public Flux<Number> getAllNumbers() {
        return numberRepository.findAll();
    }

    @Override
    public Mono<Number> addNumber(Number number) {
        return numberRepository.save(number);
    }
}
