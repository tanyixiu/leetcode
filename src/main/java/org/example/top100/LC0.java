package org.example.top100;

import java.util.ArrayList;
import java.util.List;

public class LC0 {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();


        for (int i = 0; i < intervals.length; i++) {
            int[] intervalI = intervals[i];
            int a1 = intervalI[0];
            int a2 = intervalI[1];
            for (int j = i + 1; j < intervals.length; j++) {
                int[] intervalJ = intervals[j];
                int b1 = intervalJ[0];
                int b2 = intervalJ[1];

                if (isContains(new int[] {a1, a2}, intervalJ)) {
                    a1 = Math.min(a1, b1);
                    a2 = Math.max(a2, b2);
                    i++;
                }
            }


            result.add(new int[]{a1, a2});
        }

        return result.toArray(new int[result.size()][]);
    }

    boolean isContains(int[] a, int[] b) {
        return (a[0] <= b[0] && b[0] <= a[1] || a[0] <= b[1] && b[1] <= a[1] || b[0] <= a[0] && a[1] <= b[1]);
    }
}
