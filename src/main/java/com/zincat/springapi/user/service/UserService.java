package com.zincat.springapi.user.service;

import com.zincat.springapi.common.entity.User;

/**
 * author: Menaka Lakshan
 */

public interface UserService {
    User findUserById(Long id);
}
