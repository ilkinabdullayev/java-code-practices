package info.ilkinabdullayev.basic.lesson11;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }


        String v5 = map.putIfAbsent(5, "val-" + 5);
        System.out.println("v5" + v5);

        String v23 = map.putIfAbsent(23, "val-" + 23);
        System.out.println("v23" + v23);

        map.putIfAbsent(25, null);

        map.computeIfPresent(7, (key, value) -> value + key);
        map.computeIfPresent(8, (key, value) -> null);

        String v25 = map.computeIfAbsent(25, key -> "test" + key);
        System.out.println(v25);


        map.remove(25, "bem");
        //map.get(25) -> test25

        map.remove(25, "test25");
        //map.get(25) -> null


        String defaultVal = map.getOrDefault(50, "empty");
        System.out.println("defaultVal" + defaultVal);


        map.merge(9, "test9", (v, nv) -> v.concat(nv));
        map.merge(25, "test25", (v, nv) -> v.concat(nv));

        System.out.println("------------------");
        map.forEach((key, value) -> {
            System.out.println(value);
        });
    }
}
