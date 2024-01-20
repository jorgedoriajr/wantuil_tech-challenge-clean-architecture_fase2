package br.com.fiap.techchallenge.domain.vos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class ProductName {
    private String name;

    public ProductName(String name) {
        validate(name);

        this.name = name;
    }

    private void validate(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
    }
}
