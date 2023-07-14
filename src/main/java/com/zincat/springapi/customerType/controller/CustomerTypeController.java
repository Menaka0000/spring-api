package com.zincat.springapi.customerType.controller;

import com.zincat.springapi.customerType.dto.CustomerTypeDto;
import com.zincat.springapi.customerType.service.CustomerTypeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * author: Menaka Lakshan
 */

@CrossOrigin
@RestController
@RequestMapping("/customer-type")
public class CustomerTypeController {

private final CustomerTypeService customerTypeService;

    public CustomerTypeController(CustomerTypeService customerTypeService) {
        this.customerTypeService = customerTypeService;
    }

    @GetMapping
    public List<CustomerTypeDto> getAllCustomerTypes(){
       return customerTypeService.getAllCustomerTypes();
    }
}
