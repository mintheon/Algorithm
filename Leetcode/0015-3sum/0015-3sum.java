
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();
        int startPoint, endPoint;
        int sum = 0;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {

            startPoint = i + 1;
            endPoint = nums.length - 1;

            while(startPoint < endPoint) {
                sum = nums[i] + nums[startPoint] + nums[endPoint];

                if(sum < 0) {
                    startPoint++;
                } else if (sum > 0) {
                    endPoint--;
                } else {
                    answer.add(Arrays.asList(nums[i], nums[startPoint], nums[endPoint]));

                    //중복된 값 건너뛰기
                    while (startPoint < endPoint && nums[startPoint] == nums[startPoint + 1])
                        startPoint++;
                    
                    while (startPoint < endPoint && nums[endPoint] == nums[endPoint - 1])
                        endPoint--;

                    startPoint++;
                    endPoint--;
                }
            }
        }

        return new ArrayList(answer);
    }
}