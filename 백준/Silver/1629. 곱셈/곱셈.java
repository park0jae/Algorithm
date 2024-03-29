import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long result = rec(A,B,C);
        System.out.println(result);
    }

    static long rec(int A, int B, int C) {
        if(B == 1) return A % C;
        long tmp = rec(A, B/2 ,C);
        tmp = tmp * tmp % C;
        if(B % 2 == 0) return tmp;
        return tmp * A % C;
    }
}
