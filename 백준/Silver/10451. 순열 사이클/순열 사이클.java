import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static Integer[] arr;
    static Integer[] sorted;
    static Integer[] link;
    static boolean[] check;
    static int n;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for(int i=0; i<tc; i++) {
            n = Integer.parseInt(br.readLine());

            arr = new Integer[n];
            sorted = new Integer[n];
            link = new Integer[n+1];
            check = new boolean[n+1];
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sorted[j] = arr[j];
            }
            Arrays.sort(sorted);
            
            linkedNumbers();
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    public static void linkedNumbers() {

        for(int i=0; i<arr.length; i++) {
            link[sorted[i]] = arr[i];  
        }
        // link[1] = 3
        // link[2] = 2
        // link[3] = 4

        for(int i=1; i<=arr.length; i++) {
            if(!check[link[i]]) {
                dfs(link[i]);
                cnt++;
            }
        }
    }

    public static void dfs(int start) {
        check[start] = true;
        if(!check[link[start]]) dfs(link[start]);
    }

}
