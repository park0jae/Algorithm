import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] check;
    static int dx[] = {0, 0, -1 ,1, -1, 1, -1, 1}; 
	static int dy[] = {-1, 1, 0, 0, 1, 1, -1, -1}; 
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            map = new int[m][n];
            check = new boolean[m][n];

            for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());

				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
            
            int islandCount = 0;
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(!check[i][j] && map[i][j] == 1) {
                        islandCount++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(islandCount).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int x , int y) {
        check[x][y] = true;

        for(int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny>=0 && nx < m && ny < n) {
                if(!check[nx][ny] && map[nx][ny] == 1){
                    dfs(nx,ny);
                }
            }
        }
    }
}
