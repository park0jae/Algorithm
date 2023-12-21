import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 바구니를 옮기는 게임 : 스크린은 N칸으로 나누어져 있고 스크린 아래쪽에는 M칸의 바구니가 있음
        // N > M
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int endPoint = M;
        int startPoint = endPoint - M + 1;
        int num = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i=0; i<num; i++) {
            int point = Integer.parseInt(br.readLine());
            if(point <= endPoint && point >= startPoint) {
                continue;
            } else {
                if(Math.abs(point - endPoint) > Math.abs(point-startPoint)) {
                    sum += Math.abs(point - startPoint);
                    startPoint = point;
                    endPoint = startPoint + M - 1;
                } else {
                    sum += Math.abs(point - endPoint);
                    endPoint = point;
                    startPoint = endPoint - M + 1;
                }
            }
        }
        System.out.println(sum);
    }
}
