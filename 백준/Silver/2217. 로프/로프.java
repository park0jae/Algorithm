import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // N개의 로프가 있고, 로프로 물체를 들어올릴 수 있음
        // 로프는 굵기나 길이가 달라서 들 수 있는 물체의 중량이 서로 다름

        // 9 , 10 , 15 => 27이 최대 ( 9 + 9 + 9 )
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int maxWeight = 0;
        int sum = 0;
        

        List<Integer> rope = new ArrayList<>();

        for(int i=0; i<N; i++) {
            rope.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(rope, Collections.reverseOrder());


        for(int i=1; i<=rope.size(); i++) {
            if(i == 1) {
                sum += rope.get(i-1);
            } else {
                if(sum < (rope.get(i-1) * i)) sum = rope.get(i-1) * i;
            }
            if(maxWeight < sum) maxWeight = sum;
        }
        System.out.println(maxWeight);
    }
}
