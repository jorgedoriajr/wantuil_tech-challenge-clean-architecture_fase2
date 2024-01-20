package br.com.fiap.techchallenge.interfaces.controllers.product.impl;

import java.util.List;

import br.com.fiap.techchallenge.application.usecases.product.ProductFindByCategory;
import br.com.fiap.techchallenge.interfaces.controllers.product.ProductFindByCategoryController;
import br.com.fiap.techchallenge.interfaces.controllers.product.converters.ProductToProductResponse;
import br.com.fiap.techchallenge.interfaces.controllers.product.responses.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Slf4j
public class ProductFindByCategoryControllerImpl implements ProductFindByCategoryController {

    private final ProductFindByCategory productFindByCategory;

    private final ProductToProductResponse productToProductResponse;

    public List<ProductResponse> findByCategory(@RequestParam String category) {
        var products = productFindByCategory.findByCategory(category);

        return products.stream()
                .map(productToProductResponse::convert)
                .toList();
    }
}
