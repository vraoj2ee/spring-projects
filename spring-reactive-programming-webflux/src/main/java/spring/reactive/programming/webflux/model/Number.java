package spring.reactive.programming.webflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Number {
    @Id
    private String id;
    private int value;

    public Number(int value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public int getValue() {
        return value;
    }
}
