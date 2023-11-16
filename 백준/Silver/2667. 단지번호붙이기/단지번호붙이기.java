import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int count = 0;
    static char[][] map;
    static boolean[][] check;
    static int n;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int total = 0;
        n = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>();
        map = new char[n][n];
        check = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == '1' && !check[i][j]) {
                    dfs(i,j);
                    total++;
                    result.add(count);
                    count = 0;
                }
            }
        }
        Collections.sort(result);

        sb.append(total).append('\n');
        for(int i=0; i<result.size(); i++) {
            sb.append(result.get(i)).append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        check[x][y] = true;
        count++;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if(map[nx][ny] == '1' && !check[nx][ny]) dfs(nx, ny);
        }
    }
}

