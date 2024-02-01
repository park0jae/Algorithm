class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int deliveryCount = 0;
        int pickupCount = 0;
        
        for(int i=n-1; i>=0; i--) {
            
            if(deliveries[i] != 0 || pickups[i] != 0) {
                int count = 0;
                
                while(deliveryCount < deliveries[i] || pickupCount < pickups[i]) {
                    count++;
                    deliveryCount += cap;
                    pickupCount += cap ;
                }
                
                answer += (i + 1) * 2 * count;
                
                deliveryCount -= deliveries[i];
                pickupCount -= pickups[i];
            }
        }
        
        return answer;
    }
}