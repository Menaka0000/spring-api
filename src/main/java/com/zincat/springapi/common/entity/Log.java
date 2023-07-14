package com.zincat.springapi.common.entity;

import jakarta.persistence.*;
import lombok.*;

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
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "log_id")
    private Long logId;

    @Column(name = "logged_date")
    private java.sql.Date loggedDate;

    @Column(name = "logged_time")
    private java.sql.Time loggedTime;

    @ManyToOne
    @JoinColumn(name = "log_type_id")
    private LogType logType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
