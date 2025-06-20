import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int MAX_NUM = 1_000_001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        boolean[] sieve = new boolean[MAX_NUM];
        sieve[1] = true;
        for (int i = 2; i < MAX_NUM; i++) {
            for (int j = i*2; j < MAX_NUM; j+=i) {
                sieve[j] = true;
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for (int i = start; i <= end; i++) {
            if(!sieve[i])
                sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}