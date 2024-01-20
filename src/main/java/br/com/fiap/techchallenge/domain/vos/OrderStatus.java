package br.com.fiap.techchallenge.domain.vos;


import br.com.fiap.techchallenge.domain.enums.OrderStatusEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class OrderStatus {

    OrderStatusEnum status;

    public OrderStatus(String status) {
        validate(status);

        this.status = OrderStatusEnum.valueOf(status);
    }

    private void validate(String status) {
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
    }
}
