package com.client.ws2000plus.service;

import com.client.ws2000plus.dto.SubscriptionTypeDTO;
import com.client.ws2000plus.model.SubscriptionType;

import java.util.List;

public interface SubscriptionTypeService {

    List<SubscriptionType> findAll ();

    SubscriptionType findById (Long id);

    SubscriptionType create (SubscriptionTypeDTO dto);

    SubscriptionType update (Long id, SubscriptionTypeDTO dto);

    void delete (Long id);

}
