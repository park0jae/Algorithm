import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		int maxPeople = Integer.MIN_VALUE;

		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int exit = Integer.parseInt(st.nextToken());
			int enter = Integer.parseInt(st.nextToken());

			sum -= exit;
			sum += enter;

			maxPeople = Math.max(maxPeople, sum);
		}
		System.out.println(maxPeople);
	}
}
