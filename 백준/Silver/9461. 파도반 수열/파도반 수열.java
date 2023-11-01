import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[101];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;


        for(int i=6; i<=100; i++){
            arr[i] = arr[i-1] + arr[i-5];
        }

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            sb.append(arr[num]).append("\n");
        }
        System.out.println(sb);
    }  


}

// 1 2 3 4 5 6 
// 1 1 1 2 2

// 4 : 1 + 3
// 5 : 2 + 4
// 6 : 3 + 5
// 7 : 2 + 6
