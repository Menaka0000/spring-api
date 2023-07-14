package com.zincat.springapi.contactPerson.dto;

import lombok.*;

/**
 * author: Menaka Lakshan
 */

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
