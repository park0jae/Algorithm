import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static int[] visited = new int[100001];
    public static void main(String[] args) throws IOException {
        // 수빈이 위치 현재 : X 
        // 1) 걸으면 1초후 X-1 or X+1
        // 2) 순간이동 1초후 2*X
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(N == K) System.out.println(0);
        else rec(N);
    }

    static void rec(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i=0; i<3; i++) {
                int changeCur;
                if(i == 0) {
                    changeCur = cur - 1;
                }else if(i == 1) {
                    changeCur = cur + 1;
                }else {
                    changeCur = cur * 2;
                }

                if(changeCur == K) {
                    System.out.println(visited[cur]);
                    return ;
                }
                if(changeCur < 0 || changeCur > 100000 || visited[changeCur] != 0) continue;
                queue.add(changeCur);
                visited[changeCur] = visited[cur] + 1;
            }
        }
    }
}
