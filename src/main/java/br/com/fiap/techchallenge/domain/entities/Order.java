package br.com.fiap.techchallenge.domain.entities;

import java.time.LocalDate;
import java.util.List;

import br.com.fiap.techchallenge.domain.vos.OrderAmount;
import br.com.fiap.techchallenge.domain.vos.OrderItem;
import br.com.fiap.techchallenge.domain.vos.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Order {
    private String id;
    private Customer customer;
    private List<OrderItem> items;
    private OrderStatus status;
    private LocalDate created;
    private OrderAmount amount;
}
