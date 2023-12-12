import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    static boolean[] check = new boolean[9];
    
    public static void main(String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        rec(0, arr, 1);

        System.out.println(sb);
    }

    public static void rec(int pos, int[] arr, int k ){
        
        if(pos == m){
            for(int a : arr){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return ;
        }

        for(int i=k; i<=n; i++){
            if(!check[i]){
                check[i] = true;
                arr[pos] = i;
                rec(pos + 1, arr, i + 1);
                check[i] = false;
            }
        }
    }
}
