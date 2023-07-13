package com.zincat.springapi.customer.service.impl;

import com.zincat.springapi.common.entity.ContactPerson;
import com.zincat.springapi.common.entity.Customer;
import com.zincat.springapi.common.entity.CustomerType;
import com.zincat.springapi.common.repository.CustomerRepo;
import com.zincat.springapi.contactPerson.dto.ContactPersonDto;
import com.zincat.springapi.contactPerson.service.ContactPersonService;
import com.zincat.springapi.customer.dto.CustomerDto;
import com.zincat.springapi.customer.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final ContactPersonService contactPersonService;

    public CustomerServiceImpl(CustomerRepo customerRepo, ContactPersonService contactPersonService) {
        this.customerRepo = customerRepo;
        this.contactPersonService = contactPersonService;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public boolean saveCustomer(CustomerDto customerDto) {
        if (customerRepo.existsByEmail(customerDto.getEmail())) return false;

        /**
 * first customer has been saved without it's contact persons.
 * once it's saved it's good to save each contact person with it's related saved customer
 */
        Customer customer = Customer.builder()
                .customerTypeId(new CustomerType(customerDto.getCustomerTypeId(), "Credit Customer", null))
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
        return true;
    }
}
