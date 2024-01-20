package br.com.fiap.techchallenge.interfaces.controllers.customer.converters;

import br.com.fiap.techchallenge.domain.entities.Customer;
import br.com.fiap.techchallenge.interfaces.controllers.customer.responses.CustomerResponse;

public class CustomerToCustomerResponse {

    public CustomerResponse convert(final Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .cpf(customer.getCpf().getCpf())
                .name(customer.getName().getName())
                .email(customer.getEmail().getEmail())
                .build();
    }
}
