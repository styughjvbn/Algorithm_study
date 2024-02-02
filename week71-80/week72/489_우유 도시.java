import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][][] dp=new int[n+1][n+1][3];
        for (int i = 1; i < n+1; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int i1 = 1; i1 < n+1; i1++) {
                int curMilk=Integer.parseInt(st.nextToken());
                if(curMilk==0){
                    dp[i][i1][0]=Math.max(Math.max(dp[i-1][i1][2],dp[i][i1-1][2])+1,Math.max(dp[i-1][i1][0],dp[i][i1-1][0]));
                    dp[i][i1][1]=Math.max(dp[i-1][i1][1],dp[i][i1-1][1]);
                    dp[i][i1][2]=Math.max(dp[i-1][i1][2],dp[i][i1-1][2]);
                } else if (curMilk==1) {
                    int tmp1=dp[i-1][i1][0]==0?0:dp[i-1][i1][0]+1;
                    int tmp2=dp[i][i1-1][0]==0?0:dp[i][i1-1][0]+1;
                    dp[i][i1][0]=Math.max(dp[i-1][i1][0],dp[i][i1-1][0]);
                    dp[i][i1][1]=Math.max(Math.max(tmp1,tmp2),Math.max(dp[i-1][i1][1],dp[i][i1-1][1]));
                    dp[i][i1][2]=Math.max(dp[i-1][i1][2],dp[i][i1-1][2]);
                }else{
                    int tmp1=dp[i-1][i1][1]==0?0:dp[i-1][i1][1]+1;
                    int tmp2=dp[i][i1-1][1]==0?0:dp[i][i1-1][1]+1;
                    dp[i][i1][0]=Math.max(dp[i-1][i1][0],dp[i][i1-1][0]);
                    dp[i][i1][1]=Math.max(dp[i-1][i1][1],dp[i][i1-1][1]);
                    dp[i][i1][2]=Math.max(Math.max(tmp1,tmp2),Math.max(dp[i-1][i1][2],dp[i][i1-1][2])) ;
                }
            }
        }
        System.out.println(Arrays.stream(dp[n][n]).max().getAsInt());
    }
}