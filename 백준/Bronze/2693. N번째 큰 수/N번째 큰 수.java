import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			Integer[] numbers = Stream.of(br.readLine().split(" "))
				.map(Integer::parseInt)
				.toArray(Integer[]::new);

			Arrays.sort(numbers, Collections.reverseOrder());
			System.out.println(numbers[2]);
		}
	}
}
