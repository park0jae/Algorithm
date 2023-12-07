import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int N,K;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            deque.offer(i+1);
        }

        sb.append("<");

        while(!deque.isEmpty()) {
            // 1) k번째 사람 제거 -> 앞에 제거 후 뒤로 offer, k번째 되면 제거
            for(int i=0; i<K-1; i++) {
                deque.offer(deque.poll());
            }
            // 2) 나머지 원 재개

            // 3) 제거되는 순서 출력
            if(deque.size() != 1) {
                sb.append(deque.poll()).append(", ");
            } else {
                sb.append(deque.poll()).append(">");
            }
        }
        System.out.println(sb);
    }
}
