import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        Integer[] arr = new Integer[n];


        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            
            arr[i] = num;
        }

        Arrays.sort(arr);
        
        for(int i=0; i<n; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
