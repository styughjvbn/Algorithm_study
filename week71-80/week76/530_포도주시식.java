import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=Integer.parseInt(br.readLine());
        }
        int[] dp=new int[n];
        dp[0]=nums[0];
        if(n>1) dp[1]=nums[0]+nums[1];
        if(n>2) dp[2]=Math.max(dp[1],Math.max(nums[1]+nums[2],nums[2]+nums[0]));
        for (int i = 3; i < n; i++) {
            dp[i]=Math.max(dp[i-1],Math.max(dp[i-3]+nums[i-1]+nums[i],dp[i-2]+nums[i]));
        }
        System.out.println(dp[n-1]);
    }
}