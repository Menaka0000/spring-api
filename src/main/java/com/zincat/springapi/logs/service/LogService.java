package com.zincat.springapi.logs.service;


import com.zincat.springapi.logs.dto.LogDto;

import java.text.ParseException;

/**
 * author: Menaka Lakshan
 */

public interface LogService {
    boolean saveLog(LogDto logDto) throws ParseException;
}
