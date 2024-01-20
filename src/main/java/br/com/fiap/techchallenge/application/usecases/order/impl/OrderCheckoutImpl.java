package br.com.fiap.techchallenge.application.usecases.order.impl;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.OrderCheckout;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.domain.enums.PaymentStatusEnum;
import br.com.fiap.techchallenge.domain.vos.PaymentStatus;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderCheckoutImpl implements OrderCheckout {
    private final OrderGateway orderGateway;

    @Override
    public Order checkout(final Order order) {
        return orderGateway.checkout(order);
    }
}
