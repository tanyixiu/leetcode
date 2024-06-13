package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;
import org.example.tool.Util;

public class LC3072 {
    public int[] resultArray(int[] nums) {

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        for (int i = 1; i <= nums.length; i++) {
            int vi = getVi(nums, i);
            if (arr1.size() == 0) {
                arr1.add(vi);
                continue;
            }
            if (arr2.size() == 0) {
                arr2.add(vi);
                continue;
            }
            if (greaterCount(arr1, vi) > greaterCount(arr2, vi)) {
                arr1.add(vi);
            } else if (greaterCount(arr1, vi) < greaterCount(arr2, vi)) {
                arr2.add(vi);
            } else if (arr1.size() <= arr2.size()) {
                arr1.add(vi);
            } else {
                arr2.add(vi);
            }
        }
        arr1.addAll(arr2);
        int[] result = new int[nums.length];
        for (int i = 0; i < arr1.size(); i++) {
            result[i] = arr1.get(i);
        }
        Util.printArray(result);
        return result;
    }

    private int getVi(int[] nums, int i) {
        return nums[i - 1];
    }

    private int greaterCount(List<Integer> arr, int val) {
        int count = 0;
        for (int v : arr) {
            if (v > val) {
                count++;
            }
        }
        return count;
    }
}

/**
 * 给你一个下标从 1 开始、长度为 n 的整数数组 nums 。
 * <p>
 * 现定义函数 greaterCount ，使得 greaterCount(arr, val) 返回数组 arr 中 严格大于 val 的元素数量。
 * <p>
 * 你需要使用 n 次操作，将 nums 的所有元素分配到两个数组 arr1 和 arr2 中。
 * 在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：
 * <p>
 * 如果 greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr1 。
 * 如果 greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr2 。
 * 如果 greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]) ，将 nums[i] 追加到元素数量较少的数组中。
 * 如果仍然相等，那么将 nums[i] 追加到 arr1 。
 * 连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。
 * <p>
 * 返回整数数组 result 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,3,3]
 * 输出：[2,3,1,3]
 * 解释：在前两次操作后，arr1 = [2] ，arr2 = [1] 。
 * 在第 3 次操作中，两个数组中大于 3 的元素数量都是零，并且长度相等，因此，将 nums[3] 追加到 arr1 。
 * 在第 4 次操作中，两个数组中大于 3 的元素数量都是零，但 arr2 的长度较小，因此，将 nums[4] 追加到 arr2 。
 * 在 4 次操作后，arr1 = [2,3] ，arr2 = [1,3] 。
 * 因此，连接形成的数组 result 是 [2,3,1,3] 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,14,3,1,2]
 * 输出：[5,3,1,2,14]
 * 解释：在前两次操作后，arr1 = [5] ，arr2 = [14] 。
 * 在第 3 次操作中，两个数组中大于 3 的元素数量都是一，并且长度相等，因此，将 nums[3] 追加到 arr1 。
 * 在第 4 次操作中，arr1 中大于 1 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[4] 追加到 arr1 。
 * 在第 5 次操作中，arr1 中大于 2 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[5] 追加到 arr1 。
 * 在 5 次操作后，arr1 = [5,3,1,2] ，arr2 = [14] 。
 * 因此，连接形成的数组 result 是 [5,3,1,2,14] 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,3,3,3]
 * 输出：[3,3,3,3]
 * 解释：在 4 次操作后，arr1 = [3,3] ，arr2 = [3,3] 。
 * 因此，连接形成的数组 result 是 [3,3,3,3] 。
 */
