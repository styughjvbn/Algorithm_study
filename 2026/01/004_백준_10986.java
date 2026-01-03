import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n,m;
        st = new  StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        long[] prefix = new long[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            // 입력받은 수를 바로 m으로 나누어 합산 (오버플로우 방지)
            prefix[i + 1] = (prefix[i] + Long.parseLong(st.nextToken())) % m;
        }

        long[] remains = new long[m];
        for (long i : prefix) {
            remains[(int)i]++;
        }

        long count = 0;
        for (long remain : remains) {
            if(remain < 2) continue;

            count+=remain*(remain-1)/2;
        }

        System.out.println(count);
    }
}
