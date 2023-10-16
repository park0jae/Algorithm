import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        // n >= 2 : n = n-1 + n-2
        // n == 0 : n = 0
        // n == 1 : n = 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        System.out.println(pivo(n));
    }

    public static int pivo(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        else 
            return pivo(n-1) + pivo(n-2);
    }
}
