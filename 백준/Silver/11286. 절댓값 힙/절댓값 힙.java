import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                int A = Math.abs(a);
                int B = Math.abs(b);
                if(A>B)
                    return 1;
                else if(A == B){
                    if(a>b) return 1;
                    else return -1;
                }
                else
                    return -1;
            }
        });
            
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll()).append("\n");
                }else {
                    sb.append("0\n");
                }
            }else {
                pq.offer(num);
            }
        }
        System.out.println(sb);
    }
}

