import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        boolean[] sieve = new boolean[1_001];
        sieve[1] = true;
        for (int i = 2; i < 1001; i++) {
            for (int j = i*2; j < 1001; j+=i) {
                sieve[j] = true;
            }
        }

        int result = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            if(!sieve[Integer.parseInt(st.nextToken())])
                result++;
        }
        System.out.println(result);
    }
}