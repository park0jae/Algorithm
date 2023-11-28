import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static int[][] dist;
    static boolean[][] check;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int N;
    static int M;
    static int maxDist = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        check = new boolean[N][M];
        dist = new int[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();

            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                check = new boolean[N][M];
                dist = new int[N][M];
                if(map[i][j] == 'L'){
                    bfs(i,j);
                }
            }
        }
        System.out.println(maxDist);
    }

    static void bfs(int x , int y) {
        check[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()) {
            int[] num = queue.poll();
            int curX = num[0];
            int curY = num[1];

            for(int i=0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(!check[nx][ny] && map[nx][ny] == 'L') {
                    dist[nx][ny] = dist[curX][curY] + 1;
                    check[nx][ny] = true;
                    if(maxDist < dist[nx][ny]) maxDist = dist[nx][ny];
                    queue.add(new int[]{nx,ny});
                }
            }
        }
    }
}
