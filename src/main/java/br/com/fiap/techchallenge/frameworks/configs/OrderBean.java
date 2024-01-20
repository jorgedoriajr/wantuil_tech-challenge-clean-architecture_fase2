package br.com.fiap.techchallenge.frameworks.configs;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.FindOrderByStatus;
import br.com.fiap.techchallenge.application.usecases.order.OrderCheckout;
import br.com.fiap.techchallenge.application.usecases.order.impl.FindOrderByStatusImpl;
import br.com.fiap.techchallenge.application.usecases.order.impl.OrderCheckoutImpl;
import br.com.fiap.techchallenge.frameworks.web.order.FindOrderByStatusWeb;
import br.com.fiap.techchallenge.frameworks.web.order.OrderCheckoutWeb;
import br.com.fiap.techchallenge.frameworks.web.order.impl.FindOrderByStatusWebImpl;
import br.com.fiap.techchallenge.frameworks.web.order.impl.OrderCheckoutWebImpl;
import br.com.fiap.techchallenge.interfaces.controllers.customer.converters.CustomerRequestToCustomer;
import br.com.fiap.techchallenge.interfaces.controllers.customer.converters.CustomerToCustomerResponse;
import br.com.fiap.techchallenge.interfaces.controllers.order.FindOrderByStatusController;
import br.com.fiap.techchallenge.interfaces.controllers.order.OrderCheckoutController;
import br.com.fiap.techchallenge.interfaces.controllers.order.converters.OrderRequestToOrder;
import br.com.fiap.techchallenge.interfaces.controllers.order.converters.OrderToOrderResponse;
import br.com.fiap.techchallenge.interfaces.controllers.order.impl.FindOrderByStatusControllerImpl;
import br.com.fiap.techchallenge.interfaces.controllers.order.impl.OrderCheckoutControllerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderBean {

    @Bean
    OrderCheckout orderCheckout(final OrderGateway orderRepository) {
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
    OrderCheckoutWeb orderCheckoutWeb(final OrderCheckoutController orderCheckoutController) {
        return new OrderCheckoutWebImpl(orderCheckoutController);
    }

    @Bean
    FindOrderByStatus orderFindByStatus(final OrderGateway orderRepository) {
        return new FindOrderByStatusImpl(orderRepository);
    }

    @Bean
    FindOrderByStatusController orderFindByStatusController(final FindOrderByStatus orderFindByStatus,
                                                            final OrderToOrderResponse orderToOrderResponse) {
        return new FindOrderByStatusControllerImpl(orderFindByStatus, orderToOrderResponse);
    }

    @Bean
    FindOrderByStatusWeb findOrderByStatusWeb(final FindOrderByStatusController findOrderByStatusController) {
        return new FindOrderByStatusWebImpl(findOrderByStatusController);
    }
}
