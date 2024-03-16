import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        char[] arr = number.toCharArray();
        
        // 총 문자열의 길이 (전체 - 빼야하는 수)
        int len = arr.length - k;
        // 문자 비교 시작 인덱스 
        int start = 0;
        
        for(int i=0; i<len; i++) {
            char max = '0';
            for(int j=start; j<=i + k; j++) {
               if(arr[j] > max) {
                   max = arr[j];
                   start = j + 1;
               }
            }
            sb.append(Character.toString(max));
        }
        return sb.toString();
    }
}