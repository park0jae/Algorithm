import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        
        // 주어진 수가 10보다 작으면 앞에 0을 붙여 두 자리 수로 만든다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int tmp = N;

        while (true) {
			N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
			count++;

			if (tmp == N) {
				break;
			}
		}
        System.out.println(count);
    }
}