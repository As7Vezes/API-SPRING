package com.client.ws2000plus.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionTypeDTO {

    private Long id;

    private String name;

    private Long accessMoth;

    private BigDecimal price;

    private String productKey;

}
