import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int n=Integer.parseInt(bReader.readLine());
        int[][] nums=new int[n][2];
        for (int i = 0; i < n; i++) {
            stringTokenizer=new StringTokenizer(bReader.readLine());
            nums[i][0]=Integer.parseInt(stringTokenizer.nextToken());
            nums[i][1]=Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] dp=new int[n+1];
        for (int i = n-1; i >=0 ; i--) {
//            System.out.println(Arrays.toString(dp));
            int temp=0;
            if(i+nums[i][0]<=n){
                temp=dp[i+nums[i][0]]+nums[i][1];
            }
            dp[i]=Math.max(temp,dp[i+1]);
        }
        System.out.println(dp[0]);
    }
}