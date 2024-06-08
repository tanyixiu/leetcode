package org.example.top100;

public class LC35 {
    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return start;
        }
        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        return nums[mid] > target ? search(nums, target, start, mid - 1) : search(nums, target, mid + 1, end);
    }
}
