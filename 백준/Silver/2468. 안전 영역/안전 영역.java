import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int count = 0;
    static int maxCount = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int maxHeight = 0;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }
            }
        }

        for(int height=0; height<maxHeight+1; height++) {
			count = 0;
            visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
                    // 2. 안전 영역 탐지
					if(!visited[i][j] && map[i][j] > height){
						count+=dfs(i,j,height); // 해당 안전영역 탐색 시작
					}
					
				}
			}
			maxCount = Math.max(maxCount, count);
		}
		System.out.println(maxCount);
	}
	// 안전 영역 DFS탐색
	static int dfs(int x, int y, int height) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x +dx[i];
			int ny = y +dy[i];
			
			if(nx<0 || ny<0 || nx>N-1 || ny >N-1) continue;
			if(visited[nx][ny]) continue;
			if(map[nx][ny]> height) {
				dfs(nx,ny, height);
			}
		}
		return 1;
	}
}
