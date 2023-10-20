import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] arr = null;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 1번째줄 싹 출력
        // 2번째줄 가운데 하나씩 비움
        // 3번째줄 다  채움
        // 4번째줄 3개 찍고 3개 비고
        arr = new char[n][n];

        star(0,0,n);
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(arr[i][j] == '*' ? arr[i][j] : " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);        
    }

    static void star(int x, int y, int n){
        
        if(n == 1){
            arr[x][y] = '*';
            return ;
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(!(i == 1 && j == 1)){
                    star(x + i * n / 3 , y + j * n / 3 , n / 3);
                }
            }
        }

        // 0, 0, 3
        // 
    }
}
