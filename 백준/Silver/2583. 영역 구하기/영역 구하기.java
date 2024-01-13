import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static int N,M,K;
    static int[][] map;
    static int count = 0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y=y1; y<y2; y++) {
                for(int x=x1; x<x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        List<Integer> areaCount = new ArrayList<>();
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 0) {
                    count = 0;
                    dfs(i,j);
                    areaCount.add(count);
                }
            }
        }
        Collections.sort(areaCount);
        
        sb.append(areaCount.size()).append('\n');
        for(int i : areaCount) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        map[x][y] = 1;
        count++;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx < M && ny < N) {
                if(map[nx][ny] == 0) {
                    dfs(nx,ny);
                }
            }
        }
    }
}

