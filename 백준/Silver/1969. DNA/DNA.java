import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static String[] DNA;
    static int N,M;
    static int aCount,tCount,gCount,cCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        DNA = new String[N];

        for(int i=0; i<N; i++) {
            DNA[i] = br.readLine();
        }

        for(int i=0; i<M; i++) {
            aCount = 0;
            cCount = 0;
            tCount = 0;
            gCount = 0;
            for (int j=0; j<N; j++) {
                char tmp = DNA[j].charAt(i);
                
                switch (tmp) {
                    case 'A':
                        aCount++;
                        break;
                    case 'C':
                        cCount++;
                        break;
                    case 'G':
                        gCount++;
                        break;
                    case 'T':
                        tCount++;
                        break;
                }
            }
            
            int max = 0;
            char alp = ' ';
            if(tCount >= max) {
                max = tCount;
                alp = 'T';
            }
            if(gCount >= max) {
                max = gCount;
                alp = 'G';

            }
            if(cCount >= max) {
                max = cCount;
                alp = 'C';
            }
            if(aCount >= max) {
                max = aCount;
                alp = 'A';
            }

            sb.append(Character.toString(alp));
            answer += N - max;
        }
        bw.write(sb + "\n" + answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
