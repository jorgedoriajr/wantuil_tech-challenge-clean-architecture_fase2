package br.com.fiap.techchallenge.application.usecases.customer;

import br.com.fiap.techchallenge.domain.entities.Customer;

public interface CustomerFindByCpf {
    Customer findByCpf(String cpf);
}
