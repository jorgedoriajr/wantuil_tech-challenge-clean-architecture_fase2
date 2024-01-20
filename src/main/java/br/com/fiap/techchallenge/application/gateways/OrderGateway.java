package br.com.fiap.techchallenge.application.gateways;

import java.util.List;

import br.com.fiap.techchallenge.domain.entities.Order;


public interface OrderGateway {
    Order checkout(Order order);

    List<Order> findByDeliveryStatus(List<String> status);

    Order updateDeliveryStatus(String id, String deliveryStatus);

    Order updatePaymentStatus(String id, String paymentStatus);

}
