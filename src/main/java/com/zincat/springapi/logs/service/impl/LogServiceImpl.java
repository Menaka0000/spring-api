package com.zincat.springapi.logs.service.impl;

import com.zincat.springapi.common.entity.Log;
import com.zincat.springapi.common.repository.LogRepo;
import com.zincat.springapi.customer.service.CustomerService;
import com.zincat.springapi.logType.service.LogTypeService;
import com.zincat.springapi.logs.dto.LogDto;
import com.zincat.springapi.logs.service.LogService;
import com.zincat.springapi.user.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * author: Menaka Lakshan
 */

@Service
public class LogServiceImpl implements LogService {

    private final LogRepo logRepo;
    private final UserService userService;
    private final CustomerService customerService;
    private final LogTypeService logTypeService;
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public LogServiceImpl(LogRepo logRepo, UserService userService,
                          @Lazy CustomerService customerService, LogTypeService logTypeService) {
        this.logRepo = logRepo;
        this.userService = userService;
        this.customerService = customerService;
        this.logTypeService = logTypeService;
    }

    @Override
    public boolean saveLog(LogDto logDto) throws ParseException {
        logRepo.save(Log.builder()
                .loggedDate(new java.sql.Date(119, 6, 18))
                .loggedTime(new Time(15, 5, 30))
                .user(userService.findUserById(logDto.getUserId()))
                .customer(customerService.getCustomerById(logDto.getCustomerId()))
                .logType(logTypeService.getLogTypeByType("Save"))
                .build());
        return false;
    }
}
