package com.zincat.springapi.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

/**
 * author: Menaka Lakshan
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long customerId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    @Column(name = "customer_code", length = 50, columnDefinition = "Varchar(50)", nullable = false)
    private String customerCode;

    @Column(name = "ref_no", length = 50, columnDefinition = "varchar(50)")
    private String refNo;

    @Column(name = "customer_name", length = 50, columnDefinition = "varchar(50)", nullable = false)
    private String customerName;

    @Column(name = "company_name", length = 50, columnDefinition = "varchar(50)")
    private String companyName;

    @Column(name = "nic_no", length = 50, columnDefinition = "varchar(50)")
    private String nicNo;

    @Column(name = "billing_address", length = 100, columnDefinition = "varchar(100)", nullable = false)
    private String billingAddress;

    @Column(length = 50, columnDefinition = "varchar(50)")
    private String mobile;

    @Column(length = 50, columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String email;

    @Column(length = 50, columnDefinition = "varchar(50)")
    private String country;

    @Column(length = 50, columnDefinition = "varchar(50)")
    private String city;

    @Column(length = 50, columnDefinition = "varchar(50)")
    private String gender;

    @ManyToMany
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "customer_contact_person", joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_person_id"))
    private Set<ContactPerson> contactPersons;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Log> logs;
}
