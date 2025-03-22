package com.eureka.playground;

import java.util.*;

public class MapsPlayground {
    public static void main(String[] args) {

        //HashMap Collection it doesn't preserve the order, and it hold only one null key and can hold multiple null value
        //Can't have a duplicate entry of key
        //TreeMap
        Map<Integer,String> sectors = new HashMap(); //key value
        sectors.put(10, "HealthCare"); //key value, put is to add
        sectors.put(11, "Technology");
        sectors.put(12, "RealEstate");
        sectors.put(13, "Mining");
        sectors.put(14, "Retail");

        //To retrieve a value from Map
        String sector_name = sectors.get(12); // call using the key
        System.out.println("Map output for key 12: " + sector_name);
        System.out.println("Find if 10 is present in the list: " + sectors.containsKey(10)); // returns boolean value
        System.out.println("Find if Technology is present in the list: " + sectors.containsValue("Technology")); // returns boolean value

        //sectors.remove(14);
    /*    sectors.remove(13);
        System.out.println(sectors);*/

        Set<Integer> integers = sectors.keySet(); //Similar in logic so Set
        System.out.println("The key set of Sectors is: " + integers);

        List<String> sectorNames = new ArrayList<>(Arrays.asList("HealthCare", "Technology", "RealEstate", "Mining", "Retail",
                "Technology", "RealEstate", "HealthCare", "Technology", "RealEstate", "Mining",
                "Technology", "RealEstate", "Mining"));

        //String Integer
        //HealthCare - 3
        Collection<String> values = sectors.values();
        System.out.println(values);

        Map<String, Integer> countMap = new HashMap<>();
        values.forEach(s -> {
            for (String a :
                    sectorNames) {
                if (s.equals(a) && countMap.containsKey(a)) {
                    countMap.put(s, countMap.get(a) + 1);
                } else if (s.equals(a)) {
                    countMap.put(s,1);
                }
            }
        });
        System.out.println(countMap);
    }
}
