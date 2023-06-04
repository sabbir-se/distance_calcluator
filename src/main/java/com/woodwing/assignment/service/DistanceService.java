package com.woodwing.assignment.service;

import com.woodwing.assignment.model.UserRequestModel;
import com.woodwing.assignment.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistanceService {

    private static final Logger logger = LoggerFactory.getLogger(DistanceService.class.getName());

    public String distanceCalculate(UserRequestModel userRequestModel) {
        logger.info("## Calculate distance ##");
        Double resultDistance = 0.0;
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

    public List<String> getAllUnits() {
        logger.info("## Get all available units ##");
        return Constants.unitList;
    }
}
