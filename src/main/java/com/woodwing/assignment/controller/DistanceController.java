package com.woodwing.assignment.controller;

import com.woodwing.assignment.model.UserRequestModel;
import com.woodwing.assignment.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/distance")
public class DistanceController {

    @Autowired
    private DistanceService distanceService;

    @GetMapping("/units")
    public ResponseEntity<?> getAllUnits() {
        return new ResponseEntity<>(distanceService.getAllUnits(), HttpStatus.OK);
    }
}
