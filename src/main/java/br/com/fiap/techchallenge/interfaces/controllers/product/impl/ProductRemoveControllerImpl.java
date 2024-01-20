package br.com.fiap.techchallenge.interfaces.controllers.product.impl;

import br.com.fiap.techchallenge.application.usecases.product.ProductRemove;
import br.com.fiap.techchallenge.interfaces.controllers.product.ProductRemoveController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Slf4j
public class ProductRemoveControllerImpl implements ProductRemoveController {

    private final ProductRemove productRemove;

    public void remove(@PathVariable("id") String id) {
        productRemove.remove(id);
    }
}
