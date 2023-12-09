import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] paper;
    static int zero = 0;
    static int one = 0;
    static int minus = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        paper = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0, 0, N);
        sb.append(minus).append("\n").append(zero).append("\n").append(one).append("\n");
        System.out.println(sb);
    }

    static void func(int x , int y , int N) {
        if(check(x,y,N)) {
            if(paper[x][y] == -1) minus++;
            else if(paper[x][y] == 0) zero++;
            else one++;
        } else {
            int size = N / 3;

            for(int i = 0; i < 3; i++) {
                for(int j=0; j<3; j++) {
                    func(x + size * i, y + size * j , size);
                }
            }
        }
    }

    static boolean check(int x, int y , int N) {
        int start = paper[x][y];
        for(int i=x; i < x + N; i++) {
            for(int j=y; j< y + N; j++) {
                if(start != paper[i][j])
                    return false;
            }
        }
        return true;
    }
}
