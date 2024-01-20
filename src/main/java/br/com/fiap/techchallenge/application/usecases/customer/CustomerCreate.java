package br.com.fiap.techchallenge.application.usecases.customer;

import br.com.fiap.techchallenge.domain.entities.Customer;

public interface CustomerCreate {
    Customer create(Customer customer);
}
