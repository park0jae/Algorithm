import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final char[] DUCK = {'q','u','a','c','k'};
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        solve();

    }

    private static void solve() {
        if(arr.length % 5 != 0) {
            System.out.println(-1);
            return;
        }

        int len = arr.length;
        int cnt = 0;

        while(len != 0) {
            int duckIdx = 0;
            int idx = 0;
            boolean check = false;
            int[] tmp = new int[5];

            while(idx < arr.length) {
                if(arr[idx] == DUCK[duckIdx]) {
                    tmp[duckIdx++] = idx;
                    if(duckIdx == 5) {
                        check = true;
                        len -= 5;
                        duckIdx = 0;
                        for(int i=0; i<5; i++) {
                            arr[tmp[i]] = 'O';
                        }
                    }
                }
                idx++;
            }
            if(check) cnt++;
            else break;
        }
        System.out.println(len == 0 ? cnt : -1);
    }
}
