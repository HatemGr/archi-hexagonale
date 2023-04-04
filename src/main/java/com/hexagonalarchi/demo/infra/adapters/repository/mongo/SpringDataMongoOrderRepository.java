package com.hexagonalarchi.demo.infra.adapters.repository.mongo;

import com.hexagonalarchi.demo.domain.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataMongoOrderRepository extends MongoRepository<Order, UUID> {
}
