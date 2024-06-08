package org.example.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int[] merged = intervals[0];
        while (i < intervals.length - 1) {
            if (canMerge(merged, intervals[i + 1])) {
                merged = merge(merged, intervals[i + 1]);
                i++;
                if (i == intervals.length - 1) {
                    result.add(merged);
                }
                continue;
            }
            result.add(merged);
            merged = intervals[i + 1];
        }
        return result.toArray(new int[result.size()][]);
    }

    private int[] merge(int[] a, int[] b) {
        return new int[] {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }

    private boolean canMerge(int[] a, int b[]) {
        return a[0] <= b[0] && b[0] <= a[1] || a[0] <= b[1] && b[1] <= a[1] || b[0] <= a[0] && a[1] <= b[1];
    }
}
