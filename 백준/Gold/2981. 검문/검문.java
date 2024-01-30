import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        
        // 근처에 보이는 숫자 N개를 종이에 적음 
        // 그 다음 종이에 적은 수를 M으로 나눔 , 나머지가 모두 같게 되는 M을 찾으려고 함 

        // N 개의 수가 주어졌을때 가능한 M을 모두 찾는 프로그램을 짜라.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int num = arr[1] - arr[0];

        for(int i=1; i<n; i++){
            num = gcd(num , arr[i] - arr[i-1]);
        }

        for(int i=2; i<=num; i++){
            if(num % i == 0){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b , a%b);
    }
}
