package com.zincat.springapi.common.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * author: Menaka Lakshan
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "customer_types")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_type_id")
    private Long customerTypeId;

    @Column(length = 50 , columnDefinition = "varchar(50)")
    private String type;

    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;
}
