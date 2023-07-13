package com.zincat.springapi.contactPerson.dto;

import com.zincat.springapi.common.entity.Customer;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ContactPersonDto {
    private String contactPersonId;
    private String name;
    private String designation;
    private String mobile;
    private String email;
}
