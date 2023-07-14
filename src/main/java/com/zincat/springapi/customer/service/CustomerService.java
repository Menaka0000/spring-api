package com.zincat.springapi.customer.service;

import com.zincat.springapi.common.entity.Customer;
import com.zincat.springapi.customer.dto.CustomerDto;

import java.text.ParseException;
import java.util.List;

/**
 * author: Menaka Lakshan
 */

public interface CustomerService {
    boolean saveCustomer(CustomerDto customerDto) throws ParseException;

    List<CustomerDto> getAllCustomers();

    Customer getCustomerById(Long id);

    boolean deleteCustomerById(Long id);

    List<CustomerDto> searchCustomerByAll(String keyword);
}
