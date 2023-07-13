package com.zincat.springapi.common.repository;

import com.zincat.springapi.common.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository<Log,Long> {
}
