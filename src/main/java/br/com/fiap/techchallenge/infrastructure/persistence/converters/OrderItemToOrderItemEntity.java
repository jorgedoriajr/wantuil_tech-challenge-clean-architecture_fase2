package br.com.fiap.techchallenge.infrastructure.persistence.converters;

import java.util.Objects;
import java.util.UUID;

import br.com.fiap.techchallenge.domain.vos.OrderItem;
import br.com.fiap.techchallenge.infrastructure.persistence.entities.OrderItemEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderItemToOrderItemEntity {

    public OrderItemEntity convert(final OrderItem orderItem) {
        return OrderItemEntity
                .builder()
                .product(Objects.nonNull(orderItem.getProduct()) ? UUID.fromString(orderItem.getProduct()) : null)
                .quantity(orderItem.getQuantity())
                .price(orderItem.getPrice())
                .build();
    }
}
