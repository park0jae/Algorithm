import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static boolean[] check = new boolean[1000001];
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int num;
        
        primeNumber();

        while((num = Integer.parseInt(br.readLine())) != 0){
            boolean isTrue = false;
            for(int i=2; i<= num/2; i++){
                if(!check[i] && !check[num-i]){
                    sb.append(num).append(" = ").append(i).append(" + ").append(num-i).append('\n');
                    isTrue = true;
                    break;
                }
                if(isTrue)
                    sb.append("Goldbach's conjecture is wrong.");
            }

        }
        System.out.println(sb);   

        br.close();             
    }

    public static void primeNumber(){

        for(int i=2; i<=Math.sqrt(1000000); i++){
            if(check[i]) continue;
            for(int j=i+i; j<=1000000; j+=i){
                check[j] = true;
            }
        }
    }
}
