package br.com.fiap.techchallenge.frameworks.web.order.impl;

import java.util.List;

import br.com.fiap.techchallenge.frameworks.web.order.FindOrderByStatusWeb;
import br.com.fiap.techchallenge.interfaces.controllers.order.FindOrderByStatusController;
import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class FindOrderByStatusWebImpl implements FindOrderByStatusWeb {

    private final FindOrderByStatusController findOrderByStatusController;

    public List<OrderResponse> findByStatus(final String status) {
        return findOrderByStatusController.findByStatus(status);
    }
}
