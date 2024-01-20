package br.com.fiap.techchallenge.infrastructure.configs;

import br.com.fiap.techchallenge.application.usecases.customer.CustomerCreate;
import br.com.fiap.techchallenge.application.usecases.customer.CustomerFindByCpf;
import br.com.fiap.techchallenge.application.usecases.customer.CustomerRepository;
import br.com.fiap.techchallenge.application.usecases.customer.impl.CustomerCreateImpl;
import br.com.fiap.techchallenge.application.usecases.customer.impl.CustomerFindByCpfImpl;
import br.com.fiap.techchallenge.interfaces.controllers.customer.CustomerCreateController;
import br.com.fiap.techchallenge.interfaces.controllers.customer.CustomerFindByCpfController;
import br.com.fiap.techchallenge.interfaces.controllers.customer.converters.CustomerRequestToCustomer;
import br.com.fiap.techchallenge.interfaces.controllers.customer.converters.CustomerToCustomerResponse;
import br.com.fiap.techchallenge.interfaces.controllers.customer.impl.CustomerCreateControllerImpl;
import br.com.fiap.techchallenge.interfaces.controllers.customer.impl.CustomerFindByCpfControllerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerBean {

    @Bean
    CustomerCreate customerCreate(final CustomerRepository customerRepositoryPort) {
        return new CustomerCreateImpl(customerRepositoryPort);
    }

    @Bean
    CustomerRequestToCustomer customerRequestToCustomer() {
        return new CustomerRequestToCustomer();
    }

    @Bean
    CustomerToCustomerResponse customerToCustomerResponse() {
        return new CustomerToCustomerResponse();
    }

    @Bean
    CustomerCreateController customerCreateController(final CustomerCreate customerCreate,
                                                      final CustomerRequestToCustomer customerRequestToCustomer,
                                                      final CustomerToCustomerResponse customerToCustomerResponse) {
        return new CustomerCreateControllerImpl(customerCreate, customerRequestToCustomer, customerToCustomerResponse);
    }

    @Bean
    CustomerFindByCpf customerFindByCpf(final CustomerRepository customerRepositoryPort) {
        return new CustomerFindByCpfImpl(customerRepositoryPort);
    }

    @Bean
    CustomerFindByCpfController customerFindByCpfController(final CustomerFindByCpf customerFindByCpf,
                                                            final CustomerToCustomerResponse customerToCustomerResponse) {
        return new CustomerFindByCpfControllerImpl(customerFindByCpf, customerToCustomerResponse);
    }

}
