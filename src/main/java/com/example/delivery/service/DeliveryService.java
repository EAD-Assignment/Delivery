package com.example.delivery.service;

import com.example.delivery.entity.Delivery;
import com.example.delivery.entity.DeliveryStatus;
import com.example.delivery.repo.DeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepo deliveryRepo;
    
        public Delivery createDelivery(Delivery delivery) {

        return deliveryRepo.save(delivery);
        }

        public void updateDeliveryStatus(Long deliveryId, DeliveryStatus deliveryStatus) {
        Delivery updateDeliveryStatus = deliveryRepo.findById(deliveryId).orElse(null);
        if (updateDeliveryStatus != null){
            updateDeliveryStatus.setDeliveryStatus(deliveryStatus);
            deliveryRepo.save(updateDeliveryStatus);
            }

        }

        public Optional<Delivery> getDeliveryById(Long deliveryId) {
            return deliveryRepo.findById(deliveryId);
        }

    }

