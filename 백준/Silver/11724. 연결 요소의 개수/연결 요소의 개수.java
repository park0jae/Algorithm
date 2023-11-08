import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph = new int[1001][1001];
    static boolean[] visited = new boolean[1001];
    static int N;
    static int M;

    public static void dfs(int start) {
        if(visited[start] == true) {
            return ;
        }
        else {
            visited[start] = true;
            for(int i=1; i<=N; i++) {
                if(graph[start][i] == 1) {
                    dfs(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1;
        }
        int cnt = 0;

        for(int i=1; i<=N; i++) {
            if(visited[i] == false) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
