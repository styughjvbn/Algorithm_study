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
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] boxes = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            boxes[i] = new int[]{a, b};
        }

        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int tempMax = dp[i - 1][j];
                if (j - boxes[i - 1][0] >= 0) {
                    tempMax = Math.max(tempMax, dp[i - 1][j - boxes[i - 1][0]] + boxes[i-1][1]);
                }
                dp[i][j] = tempMax;
            }
//            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(dp[n][k]);

    }
}