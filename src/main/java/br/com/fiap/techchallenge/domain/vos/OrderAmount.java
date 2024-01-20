package br.com.fiap.techchallenge.domain.vos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class OrderAmount {
    private Double amount;

    public OrderAmount(Double amount) {
        validate(amount);

        this.amount = amount;
    }

    private void validate(Double amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }
    }
}
