import java.util.*;

class Solution {
    
    static int[] discount = new int[] {10,20,30,40};
    static int maxJoin = -1;
    static int maxPrice = -1;
    
    public int[] solution(int[][] users, int[] emoticons) {
        getAllDiscount(0, emoticons.length, new int[emoticons.length], users, emoticons);
        return new int[]{maxJoin, maxPrice};
    }
    
    private void getAllDiscount(int idx, int depth, int[] discountList, int[][] users, int[] emoticons) {
        if (idx == depth) {
            calculatePrice(discountList, users, emoticons);
            return;
        }

        for (int i = 0; i < 4; i++) {
            discountList[idx] = discount[i];
            getAllDiscount(idx + 1, depth, discountList, users, emoticons);
        }
    }
    
    private void calculatePrice(int[] discountList, int[][] users, int[] emoticons) {
        int join = 0;
        int price = 0;
        
        for(int[] user : users) {
            int userMinDiscount = user[0];
            int userMaxPrice = user[1];
            
            int totalPrice = 0;
            
            for(int i=0; i<emoticons.length; i++) {
                if(userMinDiscount <= discountList[i]) {
                    double discountRate = (double) discountList[i] / 100.0;
                    int discountPrice = (int) (emoticons[i] - (emoticons[i] * discountRate));
                    totalPrice += discountPrice; 
                }
            }
            if(totalPrice >= userMaxPrice) {
                join++;
            } else {
                price += totalPrice;
            }
        }
        if(join > maxJoin) {
            maxJoin = join;
            maxPrice = price;
        } else if(join == maxJoin) {
            maxPrice = Math.max(maxPrice, price);
        } 
        return ;
    }
}