package br.com.fiap.techchallenge.frameworks.web.order;

import java.util.List;

import br.com.fiap.techchallenge.interfaces.controllers.order.FindOrderByStatusController;
import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface FindOrderByStatusWeb extends FindOrderByStatusController {

    @Operation(summary = "Find orders by status",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Find orders by status"),
            })
    @GetMapping("/order")
    List<OrderResponse> findByStatus(@RequestParam String status);
}
