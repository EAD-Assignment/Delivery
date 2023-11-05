package com.example.delivery.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Document(collection = "delivery")
public class Delivery {

    @Id
    private Long deliveryId;
    private Timestamp estimated_delivery_time;
    private Integer orderId;
    private Integer userId;
    private Timestamp actual_delivery_time;
    private Integer deliveryPersonId;
    private String deliveryAddress;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus=DeliveryStatus.PICKED_UP;
    private String completed;

}
