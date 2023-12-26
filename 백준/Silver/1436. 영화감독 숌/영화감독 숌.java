import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        // 666, 1666, 2666, 3666, 4666, 5666, 6661, 6662,6663,6664,6665
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int num = 666;

        while(N != cnt) {
            num++;
            String s =String.valueOf(num);
            if(s.contains("666")) cnt++;
        }
        System.out.println(num);
    }
}
