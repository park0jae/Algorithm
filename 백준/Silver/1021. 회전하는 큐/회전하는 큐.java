import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException{
        // N개의 원소를 포함하는 양방향 순환 큐 
        // 1. 첫 번째 원소 뽑아내기 
        // 2. 왼쪽으로 한 칸 이동 시키기 (왼쪽 애를 맨 끝으로)
        // 3. 오른쪽으로 한 칸 이동시키기  (오른쪽 애를 맨 첫번째로)
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Integer> deq = new LinkedList<Integer>();


        for(int i=1; i<=n; i++){
            deq.add(i);
        }

        int count = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int target = Integer.parseInt(st.nextToken());

            while(deq.getFirst() != target){
                if(deq.indexOf(target) <= (deq.size() /2)){
                    deq.addLast(deq.getFirst());
                    deq.removeFirst();
                }else {
                    deq.addFirst(deq.getLast());
                    deq.removeLast();
                }
                count++;
            }

            if(deq.getFirst() == target){
                deq.removeFirst();
            }
        }

        System.out.println(count);
    }
}
