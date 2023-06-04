package com.woodwing.assignment.model;

public class UserRequestModel {

    private DistanceModel firstDistance;
    private DistanceModel secondDistance;
    private String expectedResultUnit;

    public DistanceModel getFirstDistance() {
        return firstDistance;
    }

    public void setFirstDistance(DistanceModel firstDistance) {
        this.firstDistance = firstDistance;
    }

    public DistanceModel getSecondDistance() {
        return secondDistance;
    }

    public void setSecondDistance(DistanceModel secondDistance) {
        this.secondDistance = secondDistance;
    }

    public String getExpectedResultUnit() {
        return expectedResultUnit;
    }

    public void setExpectedResultUnit(String expectedResultUnit) {
        this.expectedResultUnit = expectedResultUnit;
    }
}
