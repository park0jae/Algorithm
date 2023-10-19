import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] paper;
    static int whitePaper = 0;
    static int bluePaper = 0;

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 하얀색 : 0 / 파란색 : 1

        rec(n,0,0);
        sb.append(whitePaper).append("\n").append(bluePaper);
        System.out.println(sb);
    }

    private static void rec(int n, int x, int y){

        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(paper[i][j] != paper[x][y]){
                    rec(n/2, x , y);
                    rec(n/2, x , y + n/2);
                    rec(n/2, x+n/2, y);
                    rec(n/2, x + n/2 , y + n/2);

                    return ;
                }
            }
        }

        if(paper[x][y] == 1) bluePaper++;
        else whitePaper++;
    }
}
