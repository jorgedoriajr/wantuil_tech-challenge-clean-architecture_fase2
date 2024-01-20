package br.com.fiap.techchallenge.interfaces.controllers.order.responses;

import java.time.LocalDate;
import java.util.List;

import br.com.fiap.techchallenge.interfaces.controllers.customer.responses.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class OrderResponse {
    private String id;
    private CustomerResponse customer;
    private List<OrderItemResponse> items;
    private String status;
    private LocalDate created;
    private Double amount;


    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @EqualsAndHashCode
    @ToString
    public static class OrderItemResponse {
        private String product;
        private Integer quantity;
        private Double price;
    }
}
