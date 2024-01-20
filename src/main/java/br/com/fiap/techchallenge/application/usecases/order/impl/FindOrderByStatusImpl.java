package br.com.fiap.techchallenge.application.usecases.order.impl;

import java.util.List;

import br.com.fiap.techchallenge.application.usecases.order.FindOrderByStatus;
import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.domain.entities.Order;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindOrderByStatusImpl implements FindOrderByStatus {
    private final OrderGateway orderGateway;

    @Override
    public List<Order> findByStatus(final String status) {
        final var statusList = List.of(status);

        return orderGateway.findByStatus(statusList);
    }
}
