import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        boolean isClear = true;

        int alpCnt = 0;

        for(int i=0; i<input.length(); i++) {
            if(input.charAt(i) == 'X') alpCnt++;

            if(alpCnt == 4){
                sb.append("AAAA");
                alpCnt = 0;  
            } 
            if(alpCnt == 2) {
                if((i < input.length() - 1 && input.charAt(i + 1) == '.') || i == input.length() - 1){
                    sb.append("BB");
                    alpCnt = 0;
                }
            }
            if(input.charAt(i) == '.') {
                if(alpCnt % 2 != 0) {
                    isClear = false;
                    break;
                }
                sb.append(".");
            }
        }
        if(!isClear || alpCnt != 0) System.out.println(-1);
        else System.out.println(sb);
    }
}
