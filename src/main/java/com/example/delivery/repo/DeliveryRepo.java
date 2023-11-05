package com.example.delivery.repo;

import com.example.delivery.entity.Delivery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeliveryRepo extends MongoRepository<Delivery,Long> {
}
