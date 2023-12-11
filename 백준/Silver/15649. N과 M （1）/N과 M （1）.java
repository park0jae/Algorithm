import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        boolean[] check = new boolean[n+1];
        rec(n,m,0, arr, check);
    }

    public static void rec(int n, int m, int pos, int[] arr, boolean[] check){

        if(pos == m){
            
            for(int i=0; i<m; i++){
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
            return ;
        }
        for(int i=1; i<=n; i++){
            if(!check[i]){
                check[i] = true;
                arr[pos] = i;
                rec(n,m,pos+1, arr, check);
                check[i] = false;
            }
        }
    }
}
