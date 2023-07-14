package com.zincat.springapi.common.repository;

import com.zincat.springapi.common.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: Menaka Lakshan
 */

public interface LogRepo extends JpaRepository<Log,Long> {
}
