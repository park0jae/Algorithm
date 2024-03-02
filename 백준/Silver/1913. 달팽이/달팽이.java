import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int x = n/2;
        int y = n/2;

        int limit = 1;
        int value = 1;
        int[][] map = new int[n][n];

        while (true) {
            for(int i=0; i<limit; i++) {
                map[x--][y] = value++;
            }
            if(value-1 == n*n) break;
            
            for(int i=0; i<limit; i++) {
                map[x][y++] = value++;
            }

            limit++;
            for(int i=0; i<limit; i++) {
                map[x++][y] = value++;
            }
            
            for(int i=0; i<limit; i++) {
                map[x][y--] = value++;
            }
            limit++;
        }

        StringBuilder sb = new StringBuilder();

        int resultX = 0;
        int resultY = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(target == map[i][j]) {
                    resultX = i+1;
                    resultY = j+1;
                }
                sb.append(map[i][j] + " ");
            }
            sb.append('\n');
        }
        sb.append(resultX + " " + resultY);
        System.out.println(sb);
    }
}
