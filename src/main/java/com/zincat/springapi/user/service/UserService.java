package com.zincat.springapi.user.service;

import com.zincat.springapi.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService{
    User findUserById(Long id);

}
