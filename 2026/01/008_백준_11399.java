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
        int n = Integer.parseInt(br.readLine());

        int[] needTimes = new int[n];
        st = new  StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            needTimes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(needTimes);
        int res = needTimes[0];
        for (int i = 1; i < n; i++) {
            needTimes[i] += needTimes[i - 1];
            res += needTimes[i];
        }

        System.out.println(res);
    }
}
