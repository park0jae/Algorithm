import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		// () : 2 , [] : 3 , (X) : 2 * X , [X] : 3 * X
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack();
		boolean isTrue = true;
		String s = br.readLine();
		int total = 0;
		int sum = 1;

		// 닫는거 다음에 -> 닫는게 나오면 곱해야함, 닫는거 다음에 여는게 나오면 걍 더하면 됨

		for (int i = 0; i < s.length(); i++) {
			char bracket = s.charAt(i);
			// 여는 괄호인 경우
			if (bracket == '(') {
				st.push(bracket);
				sum *= 2;
			} else if (bracket == '[') {
				st.push(bracket);
				sum *= 3;
			} else {
				if (bracket == ')') {
					if (st.empty() || st.peek() != '(') {
						isTrue = false;
						break;
					} else if (s.charAt(i - 1) == '(') {
						total += sum;
					}
					st.pop();
					sum /= 2;
				} else if (bracket == ']') {
					if (st.empty() || st.peek() != '[') {
						isTrue = false;
						break;
					} else if (s.charAt(i - 1) == '[') {
						total += sum;
					}
					st.pop();
					sum /= 3;
				}
			}
		}

		if (isTrue == false || st.size() != 0) {
			System.out.println(0);
		} else {
			System.out.println(total);
		}
	}
}
