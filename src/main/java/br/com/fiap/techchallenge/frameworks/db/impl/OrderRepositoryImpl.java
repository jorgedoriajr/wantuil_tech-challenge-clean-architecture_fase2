package br.com.fiap.techchallenge.frameworks.db.impl;

import java.util.List;
import java.util.UUID;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.frameworks.db.converters.OrderEntityToOrder;
import br.com.fiap.techchallenge.frameworks.db.converters.OrderItemToOrderItemEntity;
import br.com.fiap.techchallenge.frameworks.db.converters.OrderToOrderEntity;
import br.com.fiap.techchallenge.frameworks.db.repositories.SpringDataOrderItemRepository;
import br.com.fiap.techchallenge.frameworks.db.repositories.SpringDataOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderGateway {

    private final SpringDataOrderRepository springDataOrderRepository;

    private final SpringDataOrderItemRepository springDataOrderItemRepository;

    private final OrderToOrderEntity orderToOrderEntity;

    private final OrderItemToOrderItemEntity orderItemToOrderItemEntity;

    private final OrderEntityToOrder orderEntityToOrder;

    @Override
    public Order checkout(final Order order) {
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
    public List<Order> findByDeliveryStatus(final List<String> status) {
        final var orderEntities = springDataOrderRepository.findByDeliveryStatus(status);

        return orderEntities
                .stream()
                .map(orderEntityToOrder::convert)
                .toList();
    }

    @Override
    public Order updateDeliveryStatus(final String id, final String deliveryStatus) {
        var orderEntity = springDataOrderRepository.findById(UUID.fromString(id)).orElseThrow();

        orderEntity.setDeliveryStatus(deliveryStatus);
        orderEntity = springDataOrderRepository.save(orderEntity);

        return orderEntityToOrder.convert(orderEntity);
    }

    @Override
    public Order updatePaymentStatus(final String id, final String paymentStatus) {
        var orderEntity = springDataOrderRepository.findById(UUID.fromString(id)).orElseThrow();

        orderEntity.setPaymentStatus(paymentStatus);
        orderEntity = springDataOrderRepository.save(orderEntity);

        return orderEntityToOrder.convert(orderEntity);
    }
}
