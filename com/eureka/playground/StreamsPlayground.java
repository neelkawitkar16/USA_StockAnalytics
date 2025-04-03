package com.eureka.playground;

import java.util.*;
import java.util.stream.Stream;

public class StreamsPlayground {
    public static void main(String[] args) {

        // Collections List, Set, Map
        List<String> names = new ArrayList<>();
        names.add("neel");
        names.add("amogh");
        names.add("shone");
        System.out.println(names);

        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1); // duplicate ignored
        System.out.println(numbers);

        Map<String, Integer> ageMap = new HashMap<>();
        ageMap.put("Neel", 28);
        ageMap.put("Uday", 25);
        System.out.println(ageMap);

        //Functional Interfaces
        
    }
}
