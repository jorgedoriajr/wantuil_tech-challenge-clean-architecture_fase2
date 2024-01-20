package br.com.fiap.techchallenge.application.usecases.customer.impl;

import br.com.fiap.techchallenge.application.usecases.customer.CustomerFindByCpf;
import br.com.fiap.techchallenge.application.usecases.customer.CustomerRepository;
import br.com.fiap.techchallenge.domain.entities.Customer;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerFindByCpfImpl implements CustomerFindByCpf {
    private final CustomerRepository customerRepositoryPort;

    @Override
    public Customer findByCpf(String cpf) {
        return customerRepositoryPort.findByCpf(cpf);
    }
}
