package br.com.fiap.techchallenge.interfaces.controllers.order.requests;

import java.time.LocalDate;
import java.util.List;

import br.com.fiap.techchallenge.interfaces.controllers.customer.requests.CustomerRequest;
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
public class OrderRequest {
    private String id;
    private CustomerRequest customer;
    private List<OrderItemRequest> items;
    private String status;
    private LocalDate created;
    private Double amount;


    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @EqualsAndHashCode
    @ToString
    public static class OrderItemRequest {
        private String product;
        private Integer quantity;
        private Double price;
    }
}
