import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        // 배열에 자연수 x 넣는다
        // 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.

        // 전략 : 우선순위 큐 (우선순위가 높은 데이터가 먼저 나가는 자료구조)
        // PriorityQueue를 사용하려면 Comparable Interface를 구현해야 함

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(!priorityQueue.isEmpty()){
                    sb.append(priorityQueue.poll()).append("\n");
                }else {
                    sb.append("0\n");
                }
            }
            else {
                priorityQueue.offer(num);
            }
        }
        System.out.println(sb);
    }
}
