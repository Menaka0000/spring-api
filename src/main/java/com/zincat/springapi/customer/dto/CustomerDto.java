package com.zincat.springapi.customer.dto;

import com.zincat.springapi.contactPerson.dto.ContactPersonDto;
import com.zincat.springapi.customerType.dto.CustomerTypeDto;
import lombok.*;

import java.util.Set;

/**
 * author: Menaka Lakshan
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CustomerDto {
    private Long customerId;
    private Long customerTypeId;
    private CustomerTypeDto customerTypeDto;
    private String customerCode;
    private String refNo;
    private String customerName;
    private String companyName;
    private String nicNo;
    private String billingAddress;
    private String mobile;
    private String email;
    private String country;
    private String city;
    private String gender;
    private String userId;
    private Set<ContactPersonDto> contactPersonDtos;
}
