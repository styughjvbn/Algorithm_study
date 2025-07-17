import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int maxSqrt = (int) Math.sqrt(n);
        int[] sqrtValues = new int[maxSqrt + 1];
        for (int i = 1; i <= maxSqrt; i++) {
            sqrtValues[i] = i * i;
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int sqrtNum = (int)Math.sqrt(i);
            int remainNum = i - sqrtValues[sqrtNum];
            if(remainNum == 0){
                dp[i] = 1;
                continue;
            }
            int minNum = 100_000;
            while (sqrtNum > 0) {
                minNum = Math.min(minNum, dp[remainNum] + 1);
                sqrtNum--;
                remainNum = i - sqrtValues[sqrtNum];
            }
            dp[i] = minNum;
        }
        System.out.println(dp[n]);
    }
}