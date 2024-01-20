package br.com.fiap.techchallenge.application.usecases.order;

import java.util.List;

import br.com.fiap.techchallenge.domain.entities.Order;


public interface OrderRepository {
    Order checkout(Order order);

    List<Order> findByStatus(String status);
}
