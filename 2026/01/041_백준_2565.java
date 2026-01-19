import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[][] wires = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            wires[i] = new int[]{a, b};
        }

        Arrays.sort(wires, Comparator.comparingInt(a -> a[0]));

        int[] dp = new int[n];

        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            int tempMaxLen = 1;
            for (int j = 0; j < i; j++) {
                if (wires[j][1] < wires[i][1]) {
                    tempMaxLen = Math.max(tempMaxLen, dp[j] + 1);
                }
            }
            dp[i] = tempMaxLen;
            maxLen = Math.max(maxLen, tempMaxLen);
        }

        System.out.println(n - maxLen);

    }
}