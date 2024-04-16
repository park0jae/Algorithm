class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;
        
        for(int i=sum; i>=1; i--) {
            int x = i;
            int y = sum / i;
            
            if((x-2) * (y-2) == yellow) {
                answer = new int[]{x,y};
                break;
            }
        }
        return answer;
    }
}