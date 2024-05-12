import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			list.add(sc.nextInt());
		}
		findSevenDwarfs(0, 0, new ArrayList<>());
	}

	static void findSevenDwarfs(int index, int count, List<Integer> result) {
		if (count == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += result.get(i);
			}
			if (sum == 100) {
				result.sort(null);
				for (int height : result) {
					System.out.println(height);
				}
				System.exit(0);
			}
			return;
		}

		if (index == 9 || count == 7) {
			return;
		}

		result.add(list.get(index));
		findSevenDwarfs(index + 1, count + 1, result);

		result.remove(list.get(index));
		findSevenDwarfs(index + 1, count, result);
	}
}
