package com.example.delivery.Controller;

import com.example.delivery.entity.DeliveryStatus;
import com.example.delivery.entity.EmailMessage;
import com.example.delivery.service.DeliveryService;
import com.example.delivery.entity.Delivery;
import com.example.delivery.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private final EmailSenderService emailSenderService;
    @Autowired
    private DeliveryService deliveryService;

    public DeliveryController(EmailSenderService emailSenderService) {

        this.emailSenderService = emailSenderService;
    }

    @GetMapping("/getDelivery/{deliveryId}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable Long deliveryId) {
        Optional<Delivery> optionalDelivery = deliveryService.getDeliveryById(deliveryId);
        return optionalDelivery.map(delivery -> ResponseEntity.ok(delivery))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/createDelivery")
    public Delivery createDelivery(@RequestBody Delivery delivery){
        return deliveryService.createDelivery(delivery);
    }

    @PutMapping("/updateStatus/{deliveryId}")
    public String updateDeliveryStatus(@PathVariable Long deliveryId, @RequestParam String deliveryStatus) {
        deliveryService.updateDeliveryStatus(deliveryId, DeliveryStatus.valueOf(deliveryStatus));
        return "delivery status updated";
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailMessage emailMessage){
        this.emailSenderService.sendEmail(emailMessage.getTo(),emailMessage.getSubject(),emailMessage.getMessage());
        return "Email has been send successfully to customers.";
    }
    
}

