package com.woodwing.assignment.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static Boolean isEmptyOrNull(String str) {
        if (str == null)
            return true;
        return str.isEmpty();
    }

    /*
        If you want new units just add here like:
            add("Kilograms");
     */
    public static ArrayList<String> unitList = new ArrayList<String>() {
        {
            add("Meters");
            add("Yards");
        }
    };

    /*
        If you add new units then you need to put the distance from others unit like:
            put("Kilograms_To_Meters", 0.0015349490597851);
            ....
            so on

        Just be careful about the unit name before _To should be the same name into the unitList.
        Same after To_ unit name should be the same name into the unitList.
     */
    public static Map<String, Double> measurementMap = new HashMap<String, Double>() {
        {
            put("Meters_To_Yards", 1.0936132983);
            put("Yards_To_Meters", 0.9144);
        }
    };
}
