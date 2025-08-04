import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        if(n>1) dp[2] = 3;
        for(int i=4;i<=n;i+=2){
            dp[i] = dp[i-2]*3 + 2;
            for(int j=i-2;j>=4;j-=2){
                dp[i] += dp[i-j]*2;
            }
        }
        System.out.println(dp[n]);
    }
}