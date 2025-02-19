class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        
        double value = (double) num1 / num2;
        
        answer = (int) (value * 1000);
        
        return answer;
    }
}