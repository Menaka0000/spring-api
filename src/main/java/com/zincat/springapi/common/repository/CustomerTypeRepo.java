package com.zincat.springapi.common.repository;

import com.zincat.springapi.common.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: Menaka Lakshan
 */

public interface CustomerTypeRepo extends JpaRepository<CustomerType,Long> {
}
