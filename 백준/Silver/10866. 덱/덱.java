import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String oper = st.nextToken();

            switch(oper){
                case "push_back": 
                    int num = Integer.parseInt(st.nextToken());
                    deque.offerLast(num);
                    break;
                case "push_front":
                    num = Integer.parseInt(st.nextToken());
                    deque.offerFirst(num);
                    break;
                case "pop_front":
                    if(deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if(deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.pollLast()).append("\n");    
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "front":
                    if(deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.getFirst()).append("\n");
                    break;
                case "back":
                    if(deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.getLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
