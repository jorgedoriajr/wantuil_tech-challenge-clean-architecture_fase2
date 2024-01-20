package br.com.fiap.techchallenge.interfaces.controllers.product.impl;

import br.com.fiap.techchallenge.application.usecases.product.ProductUpdate;
import br.com.fiap.techchallenge.interfaces.controllers.product.ProductUpdateController;
import br.com.fiap.techchallenge.interfaces.controllers.product.converters.ProductRequestToProduct;
import br.com.fiap.techchallenge.interfaces.controllers.product.converters.ProductToProductResponse;
import br.com.fiap.techchallenge.interfaces.controllers.product.requests.ProductRequest;
import br.com.fiap.techchallenge.interfaces.controllers.product.responses.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Slf4j
public class ProductUpdateControllerImpl implements ProductUpdateController {

    private final ProductUpdate productUpdate;

    private final ProductRequestToProduct productRequestToProduct;

    private final ProductToProductResponse productToProductResponse;

    public ProductResponse update(@PathVariable String id,
                           @RequestBody ProductRequest productRequest) {

        log.info("Updating product {}", productRequest);

        var product = productRequestToProduct.convert(productRequest);
        product = productUpdate.update(id, product);

        return productToProductResponse.convert(product);
    }

}
