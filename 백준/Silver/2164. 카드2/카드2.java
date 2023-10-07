import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException{
        
        // N장의 카드 1 ~ N까지 번호가 붙어 있고 
        // 1번 카드가 제일 위에 , N번 카드가 제일 아래인 상태 

        // 동작 : 카드 한장 남을 때까지 
        // 제일 위에 카드를 바닥에 버림 (1번을 버리겠지 ? )
        // 그 다음 제일위에 있는 카드를 제일 아래 있는 카드 밑으로 옮김
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        Queue<Integer> queue = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());

        for(int i=1; i<=num; i++){
            queue.offer(i);
        }

        if(queue.size() >= 2){
            while(true){
            queue.poll();
            if(queue.size() == 1) break;
                queue.offer(queue.poll());
            } 
        }

        System.out.println(queue.peek());
    }
}
