package br.com.fiap.techchallenge.infrastructure.configs;

import br.com.fiap.techchallenge.application.usecases.order.OrderCheckout;
import br.com.fiap.techchallenge.application.usecases.order.OrderFindByStatus;
import br.com.fiap.techchallenge.application.usecases.order.OrderRepository;
import br.com.fiap.techchallenge.application.usecases.order.impl.OrderCheckoutImpl;
import br.com.fiap.techchallenge.application.usecases.order.impl.OrderFindByStatusImpl;
import br.com.fiap.techchallenge.interfaces.controllers.customer.converters.CustomerRequestToCustomer;
import br.com.fiap.techchallenge.interfaces.controllers.customer.converters.CustomerToCustomerResponse;
import br.com.fiap.techchallenge.interfaces.controllers.order.OrderCheckoutController;
import br.com.fiap.techchallenge.interfaces.controllers.order.OrderFindByStatusController;
import br.com.fiap.techchallenge.interfaces.controllers.order.converters.OrderRequestToOrder;
import br.com.fiap.techchallenge.interfaces.controllers.order.converters.OrderToOrderResponse;
import br.com.fiap.techchallenge.interfaces.controllers.order.impl.OrderCheckoutControllerImpl;
import br.com.fiap.techchallenge.interfaces.controllers.order.impl.OrderFindByStatusControllerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderBean {

    @Bean
    OrderCheckout orderCheckout(final OrderRepository orderRepository) {
        return new OrderCheckoutImpl(orderRepository);
    }

    @Bean
    OrderRequestToOrder orderRequestToOrder(final CustomerRequestToCustomer customerRequestToCustomer) {
        return new OrderRequestToOrder(customerRequestToCustomer);
    }

    @Bean
    OrderToOrderResponse orderToOrderResponse(final CustomerToCustomerResponse customerToCustomerResponse) {
        return new OrderToOrderResponse(customerToCustomerResponse);
    }

    @Bean
    OrderCheckoutController orderCheckoutController(final OrderCheckout orderCheckout,
                                                    final OrderRequestToOrder orderRequestToOrder,
                                                    final OrderToOrderResponse orderToOrderResponse) {
        return new OrderCheckoutControllerImpl(orderCheckout, orderRequestToOrder, orderToOrderResponse);
    }

    @Bean
    OrderFindByStatus orderFindByStatus(final OrderRepository orderRepository) {
        return new OrderFindByStatusImpl(orderRepository);
    }

    @Bean
    OrderFindByStatusController orderFindByStatusController(final OrderFindByStatus orderFindByStatus,
                                                            final OrderToOrderResponse orderToOrderResponse) {
        return new OrderFindByStatusControllerImpl(orderFindByStatus, orderToOrderResponse);
    }
}
