import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        // 과일 우유, 드링킹 요구르트 등 유제품을 2+1 세일 
        // --> 3개를 한번엣 ㅏ면 젤 싼것은 무료 나머지 두개만 지불하면 된다. (세개 안사면 정가)        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Integer[] goods = new Integer[N];

        for(int i=0; i<N; i++) {
            goods[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(goods, Comparator.reverseOrder());

        int sum = 0;
        for(int i=0; i<N; i++) {
            if(i % 3 == 2) continue;
            sum += goods[i];
        }
        System.out.println(sum);
    }
}