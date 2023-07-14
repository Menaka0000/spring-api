package com.zincat.springapi.customerType.service.impl;

import com.zincat.springapi.common.entity.CustomerType;
import com.zincat.springapi.common.repository.CustomerTypeRepo;
import com.zincat.springapi.customerType.dto.CustomerTypeDto;
import com.zincat.springapi.customerType.service.CustomerTypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Menaka Lakshan
 */

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {

    private final CustomerTypeRepo customerTypeRepo;

    public CustomerTypeServiceImpl(CustomerTypeRepo customerTypeRepo) {
        this.customerTypeRepo = customerTypeRepo;
    }

    @Override
    public List<CustomerTypeDto> getAllCustomerTypes() {
        List<CustomerTypeDto> customerTypeDtos = new ArrayList<>();
        for (CustomerType customerType : customerTypeRepo.findAll()) {
            customerTypeDtos.add(CustomerTypeDto.builder()
                    .customerTypeId(customerType.getCustomerTypeId())
                    .type(customerType.getType())
                    .build()
            );
        }
        return customerTypeDtos;
    }
}
