package br.com.fiap.techchallenge.infrastructure.persistence.repositories;

import java.util.List;
import java.util.UUID;

import br.com.fiap.techchallenge.infrastructure.persistence.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataOrderRepository extends JpaRepository<OrderEntity, UUID> {
    List<OrderEntity> findByStatus(String status);
}
