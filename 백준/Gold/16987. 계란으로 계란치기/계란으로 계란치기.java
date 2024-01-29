import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Egg> eggs = new ArrayList<>();
    static int count = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        
        // 계란: 내구도 & 무게로 이루어짐 => 내구도는 상대 계란의 무게만큼 깎이고 0이되면 깨진다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hp = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            eggs.add(new Egg(hp, weight)); 
        }
        breakEggs(0, 0);
        System.out.println(count);
    }

    static void breakEggs(int depth, int breakEggsCount) {
        if(depth == N) {
            count = Math.max(count, breakEggsCount);
            return ;
        }

        if(eggs.get(depth).hp <= 0 || breakEggsCount == N-1) {
            breakEggs(depth + 1, breakEggsCount);
            return ;
        }

        int tmp = breakEggsCount;
        for(int i=0; i<N; i++) {
            // 두개 부딪혔을 때 깨지지 않거나, 깨지는 경우
            if(i == depth || eggs.get(i).hp <= 0) continue;
            eggs.get(depth).hp -= eggs.get(i).weight;
            eggs.get(i).hp -= eggs.get(depth).weight;
            if(eggs.get(depth).hp <= 0) breakEggsCount++;
            if(eggs.get(i).hp <= 0) breakEggsCount++;
            breakEggs(depth + 1, breakEggsCount);
            eggs.get(depth).hp += eggs.get(i).weight;
            eggs.get(i).hp += eggs.get(depth).weight;
            breakEggsCount = tmp;
        }
    }

    static class Egg {
        int hp;
        int weight;
        
        public Egg(int hp, int weight) {
            this.hp = hp;
            this.weight = weight;
        }
    }
}
