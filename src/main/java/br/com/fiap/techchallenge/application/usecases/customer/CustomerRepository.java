package br.com.fiap.techchallenge.application.usecases.customer;


import br.com.fiap.techchallenge.domain.entities.Customer;

public interface CustomerRepository {
    Customer create(Customer customer);

    Customer findByCpf(String cpf);
}
