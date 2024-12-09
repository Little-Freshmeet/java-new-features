package com.jack.newfeature.java9;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListOfTest {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d");
//        list.remove(1); // throw a exception because of immutable list
        System.out.println(list);

        Set<String> set = Set.of("a", "b", "c", "d");
        System.out.println(set);

        Map<Integer, String> map = Map.ofEntries(Map.entry(1, "a"), Map.entry(2, "b"), Map.entry(3, "c"));
//        map.put(4, "d");
        System.out.println(map);
    }
}
