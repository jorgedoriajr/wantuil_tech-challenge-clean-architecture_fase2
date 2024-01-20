package br.com.fiap.techchallenge.interfaces.controllers.order.converters;

import java.util.Objects;

import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.domain.vos.OrderAmount;
import br.com.fiap.techchallenge.domain.vos.OrderItem;
import br.com.fiap.techchallenge.domain.vos.OrderStatus;
import br.com.fiap.techchallenge.interfaces.controllers.customer.converters.CustomerRequestToCustomer;
import br.com.fiap.techchallenge.interfaces.controllers.order.requests.OrderRequest;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderRequestToOrder {

    private CustomerRequestToCustomer customerRequestToCustomer;

    public Order convert(final OrderRequest orderRequest) {
        return Order
                .builder()
                .id(orderRequest.getId())
                .customer(Objects.nonNull(orderRequest.getCustomer()) ? customerRequestToCustomer.convert(orderRequest.getCustomer()) : null)
                .items(orderRequest.getItems().stream()
                        .map(item -> OrderItem.builder()
                                .product(item.getProduct())
                                .quantity(item.getQuantity())
                                .price(item.getPrice())
                                .build())
                        .toList())
                .status(new OrderStatus(orderRequest.getStatus()))
                .created(orderRequest.getCreated())
                .amount(new OrderAmount(orderRequest.getAmount()))
                .build();
    }
}
