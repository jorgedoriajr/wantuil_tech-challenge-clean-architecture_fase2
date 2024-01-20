package br.com.fiap.techchallenge.domain.vos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class ProductDescription {
    private String description;

    public ProductDescription(String description) {
        validate(description);

        this.description = description;

    }

    private void validate(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
    }
}
