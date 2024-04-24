import java.util.*;

public class Solution {
    public static int solution(int N, int number) {
        if(number == N) return 1;
        
        // 담을 통
        List<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
        
        // 최대 8개 통 
        for(int i=0; i<=8; i++) {
            list.add(new HashSet<Integer>());
        }
        list.get(1).add(N); // 숫자 1개는 무조건 자기자신
        
        for(int i=2; i<=8; i++) {
            // tmpTotal : 숫자 i개 사용 시 -> 숫자 들어갈 통
            HashSet<Integer> tmpTotal = new HashSet<>();
            
            for(int j=1; j<i; j++) {
                HashSet<Integer> tongA = list.get(j);
                HashSet<Integer> tongB = list.get(i - j);
                
                for(int numA : tongA) {
                    for(int numB : tongB) {
                        tmpTotal.add(numA + numB);
                        tmpTotal.add(numA - numB);
                        tmpTotal.add(numA * numB);
                        if(numB != 0) tmpTotal.add(numA/numB);
                    }
                }
            }
            tmpTotal.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            list.set(i, tmpTotal);
            
            if(tmpTotal.contains(number)) return i;
        }
        
        return -1;
    }
}