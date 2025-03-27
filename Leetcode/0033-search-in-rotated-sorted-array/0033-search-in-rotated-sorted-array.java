class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int hi = n - 1;
        int lo = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid])
                return mid;
            if (nums[mid] < nums[hi]) {
                if (target < nums[mid]) {
                    hi = mid - 1;
                } else if (target > nums[hi]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid]) {
                    lo = mid + 1;
                } else if (target < nums[0]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

        }
        return -1;
    }
}

// 4,5,6,7,0,1,2
// l m r
// 如果m > l 左边就是有序的, 否则右边就是有序的
// 先判断是否我们要的target是不是在有序的那边