package com.zincat.springapi.user.service.impl;

import com.zincat.springapi.common.entity.User;
import com.zincat.springapi.common.repository.UserRepo;
import com.zincat.springapi.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * author: Menaka Lakshan
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User findUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
}
