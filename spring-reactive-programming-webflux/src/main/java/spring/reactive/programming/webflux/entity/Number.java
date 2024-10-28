package spring.reactive.programming.webflux.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@Data
@Table("numbers")
public class Number {
    @Id
    private Long id;
    private int value;

    public Number(int value) {
        this.value = value;
    }

    // No-args constructor
    public Number() {}

}
