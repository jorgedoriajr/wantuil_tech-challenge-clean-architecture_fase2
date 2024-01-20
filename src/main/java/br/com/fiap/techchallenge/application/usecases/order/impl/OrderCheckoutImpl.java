package br.com.fiap.techchallenge.application.usecases.order.impl;

import br.com.fiap.techchallenge.application.usecases.order.OrderCheckout;
import br.com.fiap.techchallenge.application.usecases.order.OrderRepository;
import br.com.fiap.techchallenge.domain.entities.Order;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderCheckoutImpl implements OrderCheckout {
    private final OrderRepository orderRepository;

    @Override
    public Order checkout(Order order) {
        return orderRepository.checkout(order);
    }
}
