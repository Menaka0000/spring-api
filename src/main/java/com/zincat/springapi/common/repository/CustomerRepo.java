package com.zincat.springapi.common.repository;

import com.zincat.springapi.common.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * author: Menaka Lakshan
 */

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);

    @Query(value = "select * from customers where CONCAT(customer_code,customer_name,mobile,country,city,gender) like %:keyword%", nativeQuery = true)
    List<Customer> searchCustomerByAll(String keyword);
}
