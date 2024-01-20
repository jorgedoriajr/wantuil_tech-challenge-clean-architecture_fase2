package br.com.fiap.techchallenge.application.usecases.customer.impl;

import br.com.fiap.techchallenge.application.usecases.customer.CustomerCreate;
import br.com.fiap.techchallenge.application.usecases.customer.CustomerRepository;
import br.com.fiap.techchallenge.domain.entities.Customer;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerCreateImpl implements CustomerCreate {

    private final CustomerRepository customerRepositoryPort;

    @Override
    public Customer create(Customer customer) {
        return customerRepositoryPort.create(customer);
    }

}
