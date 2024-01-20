package br.com.fiap.techchallenge.interfaces.controllers.customer.impl;

import br.com.fiap.techchallenge.application.usecases.customer.CustomerFindByCpf;
import br.com.fiap.techchallenge.interfaces.controllers.customer.CustomerFindByCpfController;
import br.com.fiap.techchallenge.interfaces.controllers.customer.converters.CustomerToCustomerResponse;
import br.com.fiap.techchallenge.interfaces.controllers.customer.responses.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class CustomerFindByCpfControllerImpl implements CustomerFindByCpfController {

    private final CustomerFindByCpf customerFindByCpf;

    private final CustomerToCustomerResponse customerToCustomerResponse;

    public CustomerResponse findByCpf(String cpf) {
        log.info("Finding customer by CPF {}", cpf);

        var customer = customerFindByCpf.findByCpf(cpf);

        return customerToCustomerResponse.convert(customer);
    }
}
