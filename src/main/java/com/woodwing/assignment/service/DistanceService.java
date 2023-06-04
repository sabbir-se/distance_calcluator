package com.woodwing.assignment.service;

import com.woodwing.assignment.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistanceService {

    private static final Logger logger = LoggerFactory.getLogger(DistanceService.class.getName());

    public List<String> getAllUnits() {
        return Constants.unitList;
    }
}
