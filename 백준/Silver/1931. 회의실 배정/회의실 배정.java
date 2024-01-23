import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> conference = new ArrayList<>();

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            conference.add(new int[]{startTime, endTime});
        }

        conference.sort(
            Comparator.comparingInt((int[] arr) -> arr[1])
                .thenComparingInt(arr -> arr[0])
        );
        
        int preEndTime = 0;
        for(int i=0; i<N; i++) {
            if(conference.get(i)[0] >= preEndTime) {
                preEndTime = conference.get(i)[1];
                count++;
            }
        }
        System.out.println(count);
    }
}
