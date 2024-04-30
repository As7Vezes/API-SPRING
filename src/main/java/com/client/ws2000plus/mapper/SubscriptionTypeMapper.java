package com.client.ws2000plus.mapper;

import com.client.ws2000plus.dto.SubscriptionTypeDTO;
import com.client.ws2000plus.model.SubscriptionType;

public class SubscriptionTypeMapper {

    public static SubscriptionType fromDtoToEntity (SubscriptionTypeDTO dto) {
        return SubscriptionType.builder()
                .id(dto.getId())
                .name(dto.getName())
                .accessMoths(dto.getAccessMoths())
                .price(dto.getPrice())
                .productKey(dto.getProductKey())
                .build();
    }



}
