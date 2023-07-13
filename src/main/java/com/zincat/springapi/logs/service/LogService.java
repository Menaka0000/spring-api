package com.zincat.springapi.logs.service;


import com.zincat.springapi.logs.dto.LogDto;

public interface LogService {
    boolean saveLog(LogDto logDto);
}
