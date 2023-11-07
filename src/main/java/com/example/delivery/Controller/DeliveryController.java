package com.example.delivery.Controller;

import com.example.delivery.entity.DeliveryStatus;
import com.example.delivery.service.DeliveryService;
import com.example.delivery.entity.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/allDelivers")
    public List<Delivery> allDelivers(){
        return deliveryService.allDelivers();
    }

    @PostMapping("/createDeliver")
    public Delivery createDelivery(@RequestBody Delivery delivery){

        return deliveryService.createDelivery(delivery);
    }

    @PutMapping("/updateStatus/{deliveryId}")
    public String updateDeliveryStatus(@PathVariable Long deliveryId,@RequestParam DeliveryStatus deliveryStatus){
        deliveryService.updateDeliveryStatus(deliveryId,deliveryStatus);
        return "delivery status updated";

    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailMessage emailMessage){
        this.emailSenderService.sendEmail(emailMessage.getTo(),emailMessage.getSubject(),emailMessage.getMessage());
        return "Email has been send successfully to customers.";
    }

}
