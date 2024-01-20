package br.com.fiap.techchallenge.application.usecases.order.impl;

import java.util.List;

import br.com.fiap.techchallenge.application.usecases.order.OrderFindByStatus;
import br.com.fiap.techchallenge.application.usecases.order.OrderRepository;
import br.com.fiap.techchallenge.domain.entities.Order;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderFindByStatusImpl implements OrderFindByStatus {
    private final OrderRepository orderRepository;
    
    @Override
    public List<Order> findByStatus(String status) {
        return orderRepository.findByStatus(status);
    }
}
