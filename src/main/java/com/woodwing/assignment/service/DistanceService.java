package com.woodwing.assignment.service;

import com.woodwing.assignment.exception.CustomException;
import com.woodwing.assignment.model.UserRequestModel;
import com.woodwing.assignment.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistanceService {

    private static final Logger logger = LoggerFactory.getLogger(DistanceService.class.getName());

    public String distanceCalculate(UserRequestModel userRequestModel) throws CustomException {
        logger.info("## Calculate distance ##");
        validate(userRequestModel);

        double resultDistance = 0.0;
        String firstUnit = userRequestModel.getFirstDistance().getUnit();
        String secondUnit = userRequestModel.getSecondDistance().getUnit();
        String expectedUnit = userRequestModel.getExpectedResultUnit();
        logger.info("First Unit: " + firstUnit + ", Second Unit: " + secondUnit + ", Expected Unit: " + expectedUnit);

        if (firstUnit.equals(expectedUnit) && secondUnit.equals(expectedUnit)) {
            resultDistance = userRequestModel.getFirstDistance().getDistance()
                    + userRequestModel.getSecondDistance().getDistance();
        } else {
            String checkFirstUnitToExpectedUnitKey = firstUnit + "_To_" + expectedUnit;
            if (Constants.measurementMap.containsKey(checkFirstUnitToExpectedUnitKey)) {
                resultDistance += userRequestModel.getFirstDistance().getDistance()
                        * Constants.measurementMap.get(checkFirstUnitToExpectedUnitKey);
            } else {
                resultDistance += userRequestModel.getFirstDistance().getDistance();
            }

            String checkSecondUnitToExpectedUnitKey = secondUnit + "_To_" + expectedUnit;
            if (Constants.measurementMap.containsKey(checkSecondUnitToExpectedUnitKey)) {
                resultDistance += userRequestModel.getSecondDistance().getDistance()
                        * Constants.measurementMap.get(checkSecondUnitToExpectedUnitKey);
            } else {
                resultDistance += userRequestModel.getSecondDistance().getDistance();
            }
        }
        return String.format("%.2f", resultDistance) + " " + expectedUnit;
    }

    private void validate(UserRequestModel userRequestModel) throws CustomException {
        if (userRequestModel.getFirstDistance() == null) {
            throw new CustomException(HttpStatus.NOT_FOUND.value(), Constants.FIRST_DISTANCE_NOT_FOUND);
        }
        if (userRequestModel.getSecondDistance() == null) {
            throw new CustomException(HttpStatus.NOT_FOUND.value(), Constants.SECOND_DISTANCE_NOT_FOUND);
        }
        if (Constants.isEmptyOrNull(userRequestModel.getExpectedResultUnit())) {
            throw new CustomException(HttpStatus.NOT_FOUND.value(), Constants.EXPECTED_UNIT_NOT_FOUND);
        }

        if (!Constants.unitList.contains(userRequestModel.getExpectedResultUnit())) {
            throw new CustomException(HttpStatus.FORBIDDEN.value(), Constants.WRONG_EXPECTED_UNIT);
        }
        if (!Constants.unitList.contains(userRequestModel.getFirstDistance().getUnit())) {
            throw new CustomException(HttpStatus.FORBIDDEN.value(), Constants.WRONG_FIRST_DISTANCE_UNIT);
        }
        if (!Constants.unitList.contains(userRequestModel.getSecondDistance().getUnit())) {
            throw new CustomException(HttpStatus.FORBIDDEN.value(), Constants.WRONG_SECOND_DISTANCE_UNIT);
        }
    }

    public List<String> getAllUnits() {
        logger.info("## Get all available units ##");
        return Constants.unitList;
    }
}
