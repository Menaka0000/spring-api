package com.zincat.springapi.common.repository;

import com.zincat.springapi.common.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
    boolean existsByEmail(String email);
}
