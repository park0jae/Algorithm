import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Integer sec = 0;
        int[][] board;
        boolean flag = false;
        List<int[]> snake = new ArrayList<>();
        Map<Integer, String> direction = new HashMap<>();
        StringTokenizer st;
        int N,K,L;
        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        // N: 보드의 크기 , K: 사과의 위치 , L : 방향 변환 횟수 
        // L - L : 왼쪽 , L - D : 오른쪽으로 90도 회전
        // 이동한 칸에 사과 O -> 사과 없어지고 꼬리는 움직이지 않음
        // 이동한 칸에 사과 X -> 몸 길이를 줄여 꼬리가 위치한 칸을 비워줌
        
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            // 사과가 있는 곳
            board[x][y] = 1;
        }

        L = Integer.parseInt(br.readLine());
        
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            direction.put(x, c);
        }

        int curX = 0;
        int curY = 0;
        int d = 0;
        snake.add(new int[]{0,0});

        while(true) {
            sec++;

            int nx = curX + dx[d];
            int ny = curY + dy[d];

            if(nx < 0 || ny < 0 || nx >=N || ny >= N) flag = true;

            for(int i=0; i<snake.size(); i++) {
                int[] t = snake.get(i);
                if(nx == t[0] && ny == t[1]) flag = true;
            }
            if(flag) break;

            // 사과 있을 때
            if(board[nx][ny] == 1) {
                board[nx][ny] = 0;
                snake.add(new int[]{nx , ny});
            } else {
                snake.add(new int[]{nx, ny});
                snake.remove(0);
            }

            if(direction.containsKey(sec)) {
                if(direction.get(sec).equals("D")){
                    d++;
                    if(d == 4) d = 0;
                }else {
                    d--;
                    if(d == -1) d = 3;
                }
            }

            curX = nx;
            curY = ny;
        }
        System.out.println(sec);
    }

}
