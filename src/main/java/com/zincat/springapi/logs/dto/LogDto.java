package com.zincat.springapi.logs.dto;

import lombok.*;

/**
 * author: Menaka Lakshan
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class LogDto {
    private Long customerId;
    private Long logTypeId;
    private Long userId;
}
