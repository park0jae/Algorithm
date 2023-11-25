import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        check = new boolean[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        check[0][0] = true;
        bfs(0,0);
        System.out.println(map[N-1][M-1]);
        
    }

    public static void bfs(int x , int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int curX = now[0];
            int curY = now[1];

            for(int i=0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(check[nx][ny] || map[nx][ny] ==0) continue;

                q.add(new int[]{nx,ny});
                map[nx][ny] = map[curX][curY] + 1;
                check[nx][ny] = true;
            }
        }
    }
}
