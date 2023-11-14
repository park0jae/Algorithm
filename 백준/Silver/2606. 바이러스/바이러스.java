import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] computer;
    static boolean[] check;
    static int numberRange;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        numberRange = Integer.parseInt(br.readLine());
        int testCase = Integer.parseInt(br.readLine());

        computer = new int[numberRange+1][numberRange+1];
        check = new boolean[numberRange+1];

        for(int i=0; i<testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            computer[x][y] = 1;
            computer[y][x] = 1;
        }
        dfs(1);
        System.out.println(cnt - 1);
    }

    public static void dfs(int start) {

        check[start] = true;
        cnt++;
        
        for(int i=1; i<=numberRange; i++) {
            if(computer[start][i] == 1 && !check[i]) {
                dfs(i);
            }    
        }
    }
}
