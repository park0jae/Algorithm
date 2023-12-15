import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        rec(0);
        System.out.println(answer);
    }

    static void rec(int depth) {
        if(depth == N) {
            answer++;
            return;
        }
        for(int i=0; i<N; i++) {
            arr[depth] = i;
            if(possibility(depth)) {
                rec(depth+1);
            }
        }
    }
    static boolean possibility(int depth) {
        for(int i=0; i < depth; i++) {
            if(arr[depth] == arr[i]) {
                return false;
            }

            else if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i]))
                return false;
        }
        return true;
    }
}
