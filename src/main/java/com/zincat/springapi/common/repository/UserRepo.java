package com.zincat.springapi.common.repository;

import com.zincat.springapi.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
