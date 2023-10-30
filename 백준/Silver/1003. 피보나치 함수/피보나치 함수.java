import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int zeroCnt = 0;
    static int oneCnt = 0;
    static Integer[][] arr = new Integer[41][2];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());


        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            
            fibo(num);

            sb.append(arr[num][0]).append(" ").append(arr[num][1]).append("\n");
        }
        System.out.println(sb);
    }  

    static Integer[] fibo(int n){
        if(arr[n][0] == null || arr[n][1] == null){
            arr[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
            arr[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
        }
        return arr[n];
    }
}


// 3 -> 2(1,0) + 1(1) 
// 4 -> 3(2) , 2()