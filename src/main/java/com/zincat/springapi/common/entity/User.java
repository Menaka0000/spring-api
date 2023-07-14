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
@Builder
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name", length = 50, columnDefinition = "varchar(50)", nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, columnDefinition = "varchar(50)")
    private String lastName;

    @Column(name = "user_name", length = 50, columnDefinition = "varchar(50)", nullable = false)
    private String userName;

    @Column(length = 75, columnDefinition = "varchar(75)", nullable = true)
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Log> logs;
}
