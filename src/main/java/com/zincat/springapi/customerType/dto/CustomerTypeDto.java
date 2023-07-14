package com.zincat.springapi.customerType.dto;

import lombok.*;

/**
 * author: Menaka Lakshan
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CustomerTypeDto {
    private Long customerTypeId;
    private String type;
}
