package com.example.delivery.service;

import com.example.delivery.entity.Delivery;
import com.example.delivery.entity.DeliveryStatus;
import com.example.delivery.repo.DeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryService {


    @Autowired
    private DeliveryRepo deliveryRepo;
    public List<Delivery> allDelivers() {

        return deliveryRepo.findAll();
    }

    public Delivery createDelivery(Delivery delivery) {
        return deliveryRepo.save(delivery);
    }

    public void updateDeliveryStatus(Long deliveryId,DeliveryStatus deliveryStatus) {
           Delivery updateDelivery = deliveryRepo.findById(deliveryId).orElse(null);
           updateDelivery.setDeliveryStatus(deliveryStatus);
           deliveryRepo.save(updateDelivery);
    }
}
