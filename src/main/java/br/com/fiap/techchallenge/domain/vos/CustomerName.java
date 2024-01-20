package br.com.fiap.techchallenge.domain.vos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class CustomerName {
    private String name;

    public CustomerName(String name) {
        validate(name);

        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isEmpty()) {
            return;
        }

        if (name.length() < 3) {
            throw new IllegalArgumentException("Name must have at least 3 characters");
        }
    }
}
