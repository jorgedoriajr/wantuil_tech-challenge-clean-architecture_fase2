package br.com.fiap.techchallenge.infrastructure.persistence.impl;

import java.util.List;

import br.com.fiap.techchallenge.application.usecases.order.OrderRepository;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.infrastructure.persistence.converters.OrderEntityToOrder;
import br.com.fiap.techchallenge.infrastructure.persistence.converters.OrderItemToOrderItemEntity;
import br.com.fiap.techchallenge.infrastructure.persistence.converters.OrderToOrderEntity;
import br.com.fiap.techchallenge.infrastructure.persistence.repositories.SpringDataOrderItemRepository;
import br.com.fiap.techchallenge.infrastructure.persistence.repositories.SpringDataOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final SpringDataOrderRepository springDataOrderRepository;

    private final SpringDataOrderItemRepository springDataOrderItemRepository;

    private final OrderToOrderEntity orderToOrderEntity;

    private final OrderItemToOrderItemEntity orderItemToOrderItemEntity;

    private final OrderEntityToOrder orderEntityToOrder;

    @Override
    public Order checkout(Order order) {
        final var orderEntity = orderToOrderEntity.convert(order);

        final var orderEntitySaved = springDataOrderRepository.save(orderEntity);

        order.getItems().forEach(orderItem -> {
            final var orderItemEntity = orderItemToOrderItemEntity.convert(orderItem);
            orderItemEntity.setOrder(orderEntitySaved);
            springDataOrderItemRepository.save(orderItemEntity);
        });

        return orderEntityToOrder.convert(orderEntity);
    }

    @Override
    public List<Order> findByStatus(String status) {
        var orderEntities = springDataOrderRepository.findByStatus(status);

        return orderEntities
                .stream()
                .map(orderEntityToOrder::convert)
                .toList();
    }
}
