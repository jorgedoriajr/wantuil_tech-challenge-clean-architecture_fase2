package br.com.fiap.techchallenge.interfaces.controllers.product;

import br.com.fiap.techchallenge.interfaces.controllers.product.requests.ProductRequest;
import br.com.fiap.techchallenge.interfaces.controllers.product.responses.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ProductCreateController {

    @Operation(summary = "Create a new product",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Product created")
            })
    @PostMapping("/product")
    ProductResponse create(@RequestBody ProductRequest productRequest);
}
