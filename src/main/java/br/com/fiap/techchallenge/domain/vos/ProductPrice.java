package br.com.fiap.techchallenge.domain.vos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class ProductPrice {
    private final Double price;

    public ProductPrice(Double price) {
        validate(price);

        this.price = price;
    }

    private void validate(Double price) {
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }
    }
}
