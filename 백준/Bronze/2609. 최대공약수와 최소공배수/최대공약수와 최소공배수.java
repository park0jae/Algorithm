import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.chrono.MinguoChronology;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st  = new StringTokenizer(br.readLine());
        
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        
        int maxNum = Math.max(num1, num2);
        int minNum = Math.min(num1, num2);

        int answer = gcd(num1, num2);
        
        System.out.println(answer);
        System.out.println(num1 * num2 / answer);
    }

    public static int gcd(int maxNum, int minNum){

        if(minNum == 0) return maxNum;

        else return gcd(minNum, maxNum % minNum);
    }
}
