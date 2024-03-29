import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] switches = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            switches[i] = sc.nextInt();
        }
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            int gender = sc.nextInt();
            int num = sc.nextInt();
            if (gender == 1) { 
                for (int k = num; k <= n; k += num) {
                    if (switches[k] == 1) {
                        switches[k] = 0;
                    } else {
                        switches[k] = 1;
                    }
                }
            } else {
                int left = num - 1;
                int right = num + 1;
                while (left > 0 && right <= n) {
                    if (switches[left] != switches[right]) {
                        break;
                    }
                    left--;
                    right++;
                }
                for (int k = left + 1; k < right; k++) {
                    if (switches[k] == 1) {
                        switches[k] = 0;
                    } else {
                        switches[k] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(switches[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
