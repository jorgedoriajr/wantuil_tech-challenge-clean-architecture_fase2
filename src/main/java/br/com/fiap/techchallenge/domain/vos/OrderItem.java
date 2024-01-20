package br.com.fiap.techchallenge.domain.vos;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class OrderItem {
    private final String product;
    private final Integer quantity;
    private final Double price;

    public OrderItem(String product, Integer quantity, Double price) {
        validate(product, quantity, price);

        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    private void validate(String product, Integer quantity, Double price) {
        if (product == null || product.isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }

        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Quantity cannot be null or less than or equal to zero");
        }

        if (price == null || price <= 0) {
            throw new IllegalArgumentException("Price cannot be null or less than or equal to zero");
        }
    }
}
