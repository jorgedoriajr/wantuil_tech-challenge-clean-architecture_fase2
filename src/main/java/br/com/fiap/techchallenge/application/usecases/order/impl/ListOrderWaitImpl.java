package br.com.fiap.techchallenge.application.usecases.order.impl;

import java.util.Comparator;
import java.util.List;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.ListOrderWait;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.domain.enums.OrderStatusEnum;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ListOrderWaitImpl implements ListOrderWait {
    private final OrderGateway orderGateway;

    @Override
    public List<Order> orderWait() {
        final var status = List.of(OrderStatusEnum.READY.toString(),
                OrderStatusEnum.PREPARING.toString(),
                OrderStatusEnum.RECEIVED.toString());

        final var orders = orderGateway.findByStatus(status);

        return orders.stream()
                .sorted(Comparator.comparing(Order::getCreated))
                .toList();
    }
}
