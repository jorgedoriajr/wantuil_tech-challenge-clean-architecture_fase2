package br.com.fiap.techchallenge.frameworks.web.order.impl;

import br.com.fiap.techchallenge.interfaces.controllers.order.OrderCheckoutController;
import br.com.fiap.techchallenge.interfaces.controllers.order.requests.OrderRequest;
import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderCheckoutControllerImpl implements OrderCheckoutController {

    private final OrderCheckoutController orderCheckoutController;

    public OrderResponse create(final OrderRequest orderRequest) {
        return orderCheckoutController.create(orderRequest);
    }
}
