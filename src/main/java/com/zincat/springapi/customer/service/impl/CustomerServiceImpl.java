package com.zincat.springapi.customer.service.impl;

import com.zincat.springapi.common.entity.ContactPerson;
import com.zincat.springapi.common.entity.Customer;
import com.zincat.springapi.common.entity.CustomerType;
import com.zincat.springapi.common.repository.CustomerRepo;
import com.zincat.springapi.contactPerson.dto.ContactPersonDto;
import com.zincat.springapi.contactPerson.service.ContactPersonService;
import com.zincat.springapi.customer.dto.CustomerDto;
import com.zincat.springapi.customer.service.CustomerService;
import com.zincat.springapi.customerType.dto.CustomerTypeDto;
import com.zincat.springapi.logs.dto.LogDto;
import com.zincat.springapi.logs.service.LogService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author: Menaka Lakshan
 */

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final ContactPersonService contactPersonService;
    private final LogService logService;

    public CustomerServiceImpl(CustomerRepo customerRepo,
                               ContactPersonService contactPersonService,
                               LogService logService) {
        this.customerRepo = customerRepo;
        this.contactPersonService = contactPersonService;
        this.logService = logService;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customerRepo.findAll()
        ) {
            customerDtos.add(CustomerDto.builder()
                    .customerId(customer.getCustomerId())
                    .customerCode(customer.getCustomerCode())
                    .customerTypeDto(CustomerTypeDto.builder()
                            .customerTypeId(customer.getCustomerType().getCustomerTypeId())
                            .type(customer.getCustomerType().getType())
                            .build())
                    .refNo(customer.getRefNo())
                    .customerName(customer.getCustomerName())
                    .companyName(customer.getCompanyName())
                    .nicNo(customer.getNicNo())
                    .billingAddress(customer.getBillingAddress())
                    .mobile(customer.getMobile())
                    .email(customer.getEmail())
                    .country(customer.getCountry())
                    .city(customer.getCity())
                    .gender(customer.getGender())
                    .build()
            );
        }
        return customerDtos;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCustomerById(Long id) {
        try {
            customerRepo.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<CustomerDto> searchCustomerByAll(String keyword) {
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customerRepo.searchCustomerByAll(keyword)
        ) {
            customerDtos.add(CustomerDto.builder()
                    .customerId(customer.getCustomerId())
                    .customerCode(customer.getCustomerCode())
                    .customerTypeDto(CustomerTypeDto.builder()
                            .customerTypeId(customer.getCustomerType().getCustomerTypeId())
                            .type(customer.getCustomerType().getType())
                            .build())
                    .refNo(customer.getRefNo())
                    .customerName(customer.getCustomerName())
                    .companyName(customer.getCompanyName())
                    .nicNo(customer.getNicNo())
                    .billingAddress(customer.getBillingAddress())
                    .mobile(customer.getMobile())
                    .email(customer.getEmail())
                    .country(customer.getCountry())
                    .city(customer.getCity())
                    .gender(customer.getGender())
                    .build()
            );
        }
        return customerDtos;
    }

    @Override
    public boolean saveCustomer(CustomerDto customerDto) throws ParseException {
        if (customerRepo.existsByEmail(customerDto.getEmail())) return false;

        /**
         * first customer is saved without it's contact persons.
         * once it's saved it's good to save each contact person with it's related saved customer
         */
        Customer customer = Customer.builder()
                .customerType(new CustomerType(customerDto.getCustomerTypeId(), "Credit Customer", null))
                .customerCode(customerDto.getCustomerCode())
                .refNo(customerDto.getRefNo())
                .customerName(customerDto.getCustomerName())
                .companyName(customerDto.getCompanyName())
                .nicNo(customerDto.getNicNo())
                .billingAddress(customerDto.getBillingAddress())
                .mobile(customerDto.getMobile())
                .email(customerDto.getEmail())
                .country(customerDto.getCountry())
                .city(customerDto.getCity())
                .gender(customerDto.getGender())
                .contactPersons(null)
                .build();

        Customer savedCustomer = customerRepo.save(customer);

        Set<Customer> customerSet = new HashSet<>();
        customerSet.add(savedCustomer);

        for (ContactPersonDto contactPersonDto : customerDto.getContactPersonDtos()) {
            ContactPerson contactPerson = ContactPerson.builder()
                    .name(contactPersonDto.getName())
                    .designation(contactPersonDto.getDesignation())
                    .mobile(contactPersonDto.getMobile())
                    .email(contactPersonDto.getEmail())
                    .customers(customerSet)
                    .build();
            contactPersonService.saveContactPerson(contactPerson);
        }

        logService.saveLog(new LogDto(savedCustomer.getCustomerId(), 1L, 1L));
        return true;
    }
}
