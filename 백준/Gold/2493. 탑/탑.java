import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        // 일직선 위에 높이가 서로 다른 N개의 탑 세우고
        // 꼭대기에 레이저 송신기 설치  (왼쪽으로 레이저 발사)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        // 0 : 값 , 1: 높이

        String[] s = br.readLine().split(" ");

        for(int i=1; i<= n; i++){
            int cur = Integer.parseInt(s[i-1]);

            while(!stack.empty()){
                if(stack.peek()[1] >= cur){
                    sb.append(stack.peek()[0]).append(" ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()){
                sb.append("0 ");
            }

            stack.push(new int[] {i, cur});
        }
        System.out.println(sb);
    }
}
