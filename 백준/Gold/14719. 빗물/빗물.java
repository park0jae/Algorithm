import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[] heights;
	static int H, W;
	static int weight = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		heights = new int[W];
		st = new StringTokenizer(br.readLine());
		fillBlockIntoMap(st);
		countRainWeight();

		System.out.println(weight);
	}

	static void fillBlockIntoMap(StringTokenizer st) {
		for (int i = 0; i < W; i++) {
			int block = Integer.parseInt(st.nextToken());
			heights[i] = block;
		}
	}

	static void countRainWeight() {
		for (int i = 1; i < W - 1; i++) {
			int height = heights[i];

			int[] lefts = Arrays.copyOfRange(heights, 0, i);
			int[] rights = Arrays.copyOfRange(heights, i + 1, heights.length);
			int leftMax = Arrays.stream(lefts).max().getAsInt();
			int rightMax = Arrays.stream(rights).max().getAsInt();

			if (height < leftMax && height < rightMax) {
				weight += Math.min(leftMax - height, rightMax - height);
			}
		}
	}
}
