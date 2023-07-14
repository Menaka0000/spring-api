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
@Table(name = "contact_person")
public class ContactPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_person_id")
    private Long contactPersonId;
    @Column(length = 50, columnDefinition = "varchar(50)", nullable = false)
    private String name;
    @Column(length = 50, columnDefinition = "varchar(50)")
    private String designation;
    @Column(length = 50, columnDefinition = "varchar(50)", nullable = false)
    private String mobile;
    @Column(length = 50, columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String email;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "customer_contact_person", joinColumns = @JoinColumn(name = "contact_person_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Customer> customers;
}
