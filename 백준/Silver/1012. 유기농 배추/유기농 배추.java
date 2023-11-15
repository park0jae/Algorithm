import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] map;
    static boolean[][] check;
    static int N;
    static int M;
    static int K;
    public static void main(String[] args) throws IOException {
        
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        int cnt = 0;

        while(true) {
            if(tc == 0) break;
            cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            check = new boolean[M][N];

            List<Integer[]> target = new ArrayList<>();

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            for(int x = 0; x< M; x++) {

                for(int y =0; y< N; y++) {
                    if(map[x][y] == 1 && !check[x][y]) {
                        dfs(x,y);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
            tc--;
        }
        System.out.println(sb);
    }
    
    public static void dfs(int x, int y) {
        check[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny>=0 && nx < M && ny < N) {
                if(!check[nx][ny] && map[nx][ny] == 1) {
                    dfs(nx , ny);
                }
            }
        }
    }
}
