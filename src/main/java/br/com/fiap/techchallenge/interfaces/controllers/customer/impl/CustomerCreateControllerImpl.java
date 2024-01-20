package br.com.fiap.techchallenge.interfaces.controllers.customer.impl;

import br.com.fiap.techchallenge.application.usecases.customer.CustomerCreate;
import br.com.fiap.techchallenge.interfaces.controllers.customer.CustomerCreateController;
import br.com.fiap.techchallenge.interfaces.controllers.customer.converters.CustomerRequestToCustomer;
import br.com.fiap.techchallenge.interfaces.controllers.customer.converters.CustomerToCustomerResponse;
import br.com.fiap.techchallenge.interfaces.controllers.customer.requests.CustomerRequest;
import br.com.fiap.techchallenge.interfaces.controllers.customer.responses.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class CustomerCreateControllerImpl implements CustomerCreateController {

    private final CustomerCreate customerCreate;

    private final CustomerRequestToCustomer customerRequestToCustomer;

    private final CustomerToCustomerResponse customerToCustomerResponse;

    public CustomerResponse create(CustomerRequest customerRequest) {
        log.info("Creating customer {}", customerRequest);

        var customer = customerRequestToCustomer.convert(customerRequest);

        customer = customerCreate.create(customer);

        return customerToCustomerResponse.convert(customer);
    }

}
