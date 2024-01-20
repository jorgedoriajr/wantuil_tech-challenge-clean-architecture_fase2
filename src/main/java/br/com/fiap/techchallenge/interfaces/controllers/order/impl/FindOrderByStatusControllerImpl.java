package br.com.fiap.techchallenge.interfaces.controllers.order.impl;

import java.util.List;

import br.com.fiap.techchallenge.application.usecases.order.FindOrderByStatus;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.interfaces.controllers.order.FindOrderByStatusController;
import br.com.fiap.techchallenge.interfaces.controllers.order.converters.OrderToOrderResponse;
import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class FindOrderByStatusControllerImpl implements FindOrderByStatusController {

    private final FindOrderByStatus orderFindByStatus;

    private final OrderToOrderResponse orderToOrderResponse;

    public List<OrderResponse> findByStatus(final String status) {
        final List<Order> orders = orderFindByStatus.findByStatus(status);

        return orders.stream()
                .map(orderToOrderResponse::convert)
                .toList();
    }
}
