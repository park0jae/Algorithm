import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer[] arr = new Integer[5];

        for(int i=0; i<5; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<4; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;

                    for(int num : arr){
                        sb.append(num).append(" ");
                    }
                    sb.append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
