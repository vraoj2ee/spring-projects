package spring.reactive.programming.webflux.repository;

import spring.reactive.programming.webflux.entity.Number;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRepository extends ReactiveCrudRepository<Number, Long> {
}
