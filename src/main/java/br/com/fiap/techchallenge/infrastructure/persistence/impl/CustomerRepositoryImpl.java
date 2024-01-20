package br.com.fiap.techchallenge.infrastructure.persistence.impl;

import br.com.fiap.techchallenge.application.usecases.customer.CustomerRepository;
import br.com.fiap.techchallenge.domain.entities.Customer;
import br.com.fiap.techchallenge.infrastructure.persistence.converters.CustomerEntityToCustomer;
import br.com.fiap.techchallenge.infrastructure.persistence.converters.CustomerToCustomerEntity;
import br.com.fiap.techchallenge.infrastructure.persistence.repositories.SpringDataCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final SpringDataCustomerRepository springDataCustomerRepository;

    private final CustomerToCustomerEntity customerToCustomerEntity;

    private final CustomerEntityToCustomer customerEntityToCustomer;

    @Override
    public Customer create(Customer customer) {
        var customerEntity = customerToCustomerEntity.convert(customer);
        customerEntity = springDataCustomerRepository.save(customerEntity);

        return customerEntityToCustomer.convert(customerEntity);
    }

    @Override
    public Customer findByCpf(String cpf) {
        var customerEntity = springDataCustomerRepository.findByCpf(cpf);

        return customerEntityToCustomer.convert(customerEntity);
    }
}
