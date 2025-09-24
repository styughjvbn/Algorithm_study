import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Integer> coins = new HashSet<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }
        int[] dp = new int[k+1];
        for (int coin: coins) {
            if(coin > k) continue;
            dp[coin] = 1;
            for (int j = coin + 1; j <= k; j++) {
                if(dp[j-coin] == 0) continue;
                if(dp[j]==0){
                    dp[j] = dp[j - coin]+1;
                }else{
                    dp[j] = Math.min(dp[j], dp[j - coin]+1);
                }

            }
        }

        System.out.println(dp[k]==0?-1:dp[k]);
    }
}