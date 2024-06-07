package org.example.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = sortedString(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(key, newList);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String sortedString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        return new ArrayList<>(
                Arrays.stream(strs).collect(Collectors.groupingBy(this::sortedString))
                        .values());
    }
}
