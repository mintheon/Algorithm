// int min weight, index
// water = max.

// O(n)
// for -> max index, max
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right) {
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, minHeight * (right - left));

            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }


        // for(int i = 0; i < height.length; i++) {
        //     for(int j = i + 1; j < height.length; j++) {
        //         int minHeight = Math.min(height[i], height[j]);

        //         water = Math.max(water, minHeight * (j - i));
        //     }
        // }

        return max;
    }
}