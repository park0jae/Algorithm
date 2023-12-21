import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int cnt = 0;
        int price = Integer.parseInt(br.readLine());

        // 일단 젤 큰걸로 거슬러줘야하는데
        // 그 다음에, 그 다음 돈도 거슬러줄 수 있으면 거슬러주는거임


        while(true) {
            if(price == 0) break;

            if(price - 5 >= 0 && ((price - 5) % 2 == 0 || (price-5) % 5 == 0)) {
                cnt++;
                price -= 5;
            }else if(price - 2 >= 0 && (price - 2) % 2 == 0) {
                cnt++;
                price -= 2;
            } else {
                cnt = -1;
                break;
            }
        }
        System.out.println(cnt);
    }
}
