package com.client.ws2000plus.service.impl;

import com.client.ws2000plus.dto.SubscriptionTypeDTO;
import com.client.ws2000plus.exception.BadRequestException;
import com.client.ws2000plus.exception.NotFoundException;
import com.client.ws2000plus.model.SubscriptionType;
import com.client.ws2000plus.repository.SubscriptionTypeRepository;
import com.client.ws2000plus.service.SubscriptionTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {

    private final SubscriptionTypeRepository subscriptionTypeRepository;

    SubscriptionTypeServiceImpl (SubscriptionTypeRepository subscriptionTypeRepository) {
        this.subscriptionTypeRepository = subscriptionTypeRepository;
    }

    @Override
    public List<SubscriptionType> findAll() {
        return subscriptionTypeRepository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {
        return getSubscriptionType(id);
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDTO dto) {
        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("Id deve ser nulo!");
        }
        return subscriptionTypeRepository.save(SubscriptionType.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .accessMoth(dto.getAccessMoth())
                        .price(dto.getPrice())
                        .productKey(dto.getProductKey())
                .build());
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionTypeDTO dto) {
        getSubscriptionType(id);

        return subscriptionTypeRepository.save(SubscriptionType.builder()
                .id(id)
                .name(dto.getName())
                .accessMoth(dto.getAccessMoth())
                .price(dto.getPrice())
                .productKey(dto.getProductKey())
                .build());
    }

    @Override
    public void delete(Long id) {
        getSubscriptionType(id);

        subscriptionTypeRepository.deleteById(id);
    }

    private SubscriptionType getSubscriptionType(Long id) {
        Optional<SubscriptionType> optionalSubscriptionType = subscriptionTypeRepository.findById(id);

        if(optionalSubscriptionType.isEmpty()) {
            throw new NotFoundException("SubscriptionType não encontrado");
        }
        return optionalSubscriptionType.get();
    }
}
