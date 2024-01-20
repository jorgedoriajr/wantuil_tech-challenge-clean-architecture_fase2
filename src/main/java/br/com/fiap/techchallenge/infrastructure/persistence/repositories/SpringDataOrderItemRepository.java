package br.com.fiap.techchallenge.infrastructure.persistence.repositories;

import java.util.UUID;

import br.com.fiap.techchallenge.infrastructure.persistence.entities.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataOrderItemRepository extends JpaRepository<OrderItemEntity, UUID> {
}
