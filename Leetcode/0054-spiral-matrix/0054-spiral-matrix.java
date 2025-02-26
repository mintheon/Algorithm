class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();

        int size = matrix.length * matrix[0].length;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(answer.size() < size) {
            for(int i = left; i <= right; i++) {
                answer.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++) {
                answer.add(matrix[i][right]);
            }
            right--;

            if(bottom < top) {
                break;
            }

            for(int i = right; i >= left; i--) {
                answer.add(matrix[bottom][i]);
            }
            bottom--;

            if(right < left) {
                break;
            }

            for(int i = bottom; i >= top; i--) {
                answer.add(matrix[i][left]);
            }
            left++;
        }

        return answer;
    }
}