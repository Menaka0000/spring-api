package com.zincat.springapi.common.repository;

import com.zincat.springapi.common.entity.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: Menaka Lakshan
 */

public interface ContactPersonRepo extends JpaRepository<ContactPerson,Long> {
}
