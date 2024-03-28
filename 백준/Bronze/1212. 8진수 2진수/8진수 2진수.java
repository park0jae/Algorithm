import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String octalNum = br.readLine();
        
        for(int i=0; i<octalNum.length(); i++) {
            int t = octalNum.charAt(i) - '0';
            String s = Integer.toBinaryString(t);
            if(s.length() == 3) {
                sb.append(s);
            }else if(s.length() == 2 && i != 0) {
                sb.append("0" + s);
            }else if(s.length() == 1 && i != 0) {
                sb.append("00" + s);
            }else {
                sb.append(s);
            }
        }
        System.out.println(sb);
    }
}
