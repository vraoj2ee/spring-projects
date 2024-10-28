package spring.reactive.programming.webflux.repository;

import spring.reactive.programming.webflux.model.Number;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRepository extends ReactiveMongoRepository<Number, String> {
}
