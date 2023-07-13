package com.zincat.springapi.logs.service.impl;

import com.zincat.springapi.common.entity.Log;
import com.zincat.springapi.common.repository.LogRepo;
import com.zincat.springapi.logs.dto.LogDto;
import com.zincat.springapi.logs.service.LogService;
import com.zincat.springapi.user.service.UserService;

import java.util.Date;

public class LogServiceImpl implements LogService {

    private final LogRepo logRepo;
    private final UserService userService;

    public LogServiceImpl(LogRepo logRepo, UserService userService){
        this.logRepo = logRepo;
        this.userService = userService;
    }

    @Override
    public boolean saveLog(LogDto logDto) {
        logRepo.save(Log.builder()
                .loggedDate(new Date())
                .loggedTime(new Date())
                .build());
        return false;
    }
}
