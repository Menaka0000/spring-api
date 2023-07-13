package com.zincat.springapi.customer.service;

import com.zincat.springapi.common.entity.Customer;
import com.zincat.springapi.customer.dto.CustomerDto;

import java.util.List;
import java.util.Set;

public interface CustomerService {
    boolean saveCustomer(CustomerDto customerDto);
    List<Customer> getAllCustomers();
}
