import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() == s2.length()){
                    int sum1 = 0;
                    int sum2 = 0;
                    
                    for(int i=0; i < s1.length(); i++){
                        if(s1.charAt(i) <= '9' && s1.charAt(i) >= '0'){
                            sum1 += Integer.parseInt(String.valueOf(s1.charAt(i)));
                        }
                    }
                    for(int i=0; i < s2.length(); i++){
                        if(s2.charAt(i) <= '9' && s2.charAt(i) >= '0'){
                            sum2 += Integer.parseInt(String.valueOf(s2.charAt(i)));
                        }
                    }
                    if(sum1 == sum2){
                        return s1.compareTo(s2);
                    }
                    else 
                        return sum1 - sum2;
                }else {
                    return s1.length() - s2.length();
                }
            }
        });

        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]).append('\n');
        }

        System.out.println(sb);
    }
}
