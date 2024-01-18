import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // L : 암호 길이 
    // C : 알파벳 개수 
    static int L;
    static int C;
    static char[] alp;
    static boolean[] check;
    static char[] code;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alp = new char[C];
        code = new char[L];
        check = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            alp[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alp);
        makeAlp(0, 0);
    }

    // 암호는 최소 한 개의 모음(a, e, i, o, u) & 최소 두 개의 자음으로 구성
    public static void makeAlp(int n, int pos) {
        if(pos == L) {
            if(isValid()) {
                System.out.println(code);
            }
            return ;
        }
        for(int i=n; i<C; i++) {
            code[pos] = alp[i];
            makeAlp(i+1, pos+1);
        }
    }

    public static boolean isValid() {
        int moum = 0;
        int jaum = 0;

        for (char x : code) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                moum++;
            } else {
                jaum++;
            }
        }

        if (moum >= 1 && jaum >= 2) {
            return true;
        }
        return false;
    }
}
