package com.zincat.springapi.common.response;

import lombok.*;

/**
 * author: Menaka Lakshan
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GenericResponse {
    private Integer statusCode;
    private String message;
    private Object data;
}
