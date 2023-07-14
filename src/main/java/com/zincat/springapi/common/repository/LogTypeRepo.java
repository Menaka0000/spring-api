package com.zincat.springapi.common.repository;

import com.zincat.springapi.common.entity.LogType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: Menaka Lakshan
 */

public interface LogTypeRepo extends JpaRepository<LogType, Long> {
    LogType getLogTypeByType(String type);
}
