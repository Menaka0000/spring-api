package com.zincat.springapi.logType.service.impl;

import com.zincat.springapi.common.entity.LogType;
import com.zincat.springapi.common.repository.LogTypeRepo;
import com.zincat.springapi.logType.service.LogTypeService;
import org.springframework.stereotype.Service;

/**
 * author: Menaka Lakshan
 */

@Service
public class LogTypeServiceImpl implements LogTypeService {

    private final LogTypeRepo logTypeRepo;

    public LogTypeServiceImpl(LogTypeRepo logTypeRepo) {
        this.logTypeRepo = logTypeRepo;
    }

    @Override
    public LogType getLogTypeByType(String type) {
        return logTypeRepo.getLogTypeByType(type);
    }
}
