package br.com.fiap.techchallenge.interfaces.controllers.product;

import java.util.List;

import br.com.fiap.techchallenge.application.usecases.product.ProductFind;
import br.com.fiap.techchallenge.interfaces.controllers.product.converters.ProductToProductResponse;
import br.com.fiap.techchallenge.interfaces.controllers.product.responses.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ProductFindController {

    @Operation(summary = "List products",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List products"),
                    @ApiResponse(responseCode = "404", description = "Product not found")
            })
    @GetMapping("/product")
    List<ProductResponse> find() ;
}
