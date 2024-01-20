package br.com.fiap.techchallenge.application.usecases.order.impl;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.UpdateDeliveryStatus;
import br.com.fiap.techchallenge.application.usecases.order.UpdatePaymentStatus;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.domain.vos.DeliveryStatus;
import br.com.fiap.techchallenge.domain.vos.PaymentStatus;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdatePaymentStatusImpl implements UpdatePaymentStatus {

    private final OrderGateway orderGateway;

    @Override
    public Order updatePaymentStatus(final String id, final String paymentStatus) {

        return orderGateway.updatePaymentStatus(id, paymentStatus);
    }
}
