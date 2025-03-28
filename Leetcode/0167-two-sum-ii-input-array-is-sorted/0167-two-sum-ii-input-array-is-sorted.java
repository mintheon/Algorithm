class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];

            if(sum == target) {
                return new int[]{left + 1, right + 1};
            }

            if(sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{0, 0};

        // for(int i = 0; i < numbers.length - 1; i++) {
        //     for(int j = i + 1; j < numbers.length; j++) {
        //         if(numbers[i] + numbers[j] == target) {
        //             return new int[] {i + 1, j + 1};
        //         }
        //     }
        // }

        // return new int[]{0, 0};
    }
}