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
@Table(name = "log_types")
public class LogType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "log_type_id")
    private Long logTypeId;

    @Column(length = 50 , columnDefinition = "varchar(50)")
    private String type;

    @OneToMany(mappedBy = "logType")
    private Set<Log> logs;
}
