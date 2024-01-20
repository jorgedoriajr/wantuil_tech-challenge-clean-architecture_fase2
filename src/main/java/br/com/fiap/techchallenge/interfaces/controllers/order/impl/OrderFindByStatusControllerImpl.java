package br.com.fiap.techchallenge.interfaces.controllers.order.impl;

import java.util.List;

import br.com.fiap.techchallenge.application.usecases.order.OrderFindByStatus;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.interfaces.controllers.order.OrderFindByStatusController;
import br.com.fiap.techchallenge.interfaces.controllers.order.converters.OrderToOrderResponse;
import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Slf4j
public class OrderFindByStatusControllerImpl implements OrderFindByStatusController {

    private final OrderFindByStatus orderFindByStatus;

    private final OrderToOrderResponse orderToOrderResponse;

    public List<OrderResponse> get(@RequestParam String status) {
        final List<Order> orders = orderFindByStatus.findByStatus(status);

        return orders.stream()
                .map(orderToOrderResponse::convert)
                .toList();
    }
}
