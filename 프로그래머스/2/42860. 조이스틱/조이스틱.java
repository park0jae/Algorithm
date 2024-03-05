import java.util.*;

class Solution {
    public int solution(String name) {
        // 단어 개수 총 26 
        int answer = 0;
        int move = name.length() - 1;
        
        // 상하 최솟값 구하기 (위로 하는게 적은지, 아래로 하는게 적은지 판단)
        for(int i=0; i<name.length(); i++) {
            // 알파벳 1 - 알파벳 2 or 알파벳 2 - 알파벳 1 비교하기
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A')); 
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                // 좌우 최소를 구해봅시다.
                // 1.A문자열이 아닌 문자를 찾을때까지 오른쪽으로 쭉 이동
                int endA = i + 1;
                while(endA < name.length() && name.charAt(endA) == 'A') {
                    endA++;
                }
                // 2.오른쪽으로 갔다가 왼쪽으로 꺾는 케이스
                move = Math.min(move, i * 2 + (name.length() - endA));
                // 3.왼쪽으로 갔다가 오른쪽으로 꺾는 케이스
                move = Math.min(move, i + (name.length() - endA) * 2);
            }
        }
        return answer + move;
    }
}