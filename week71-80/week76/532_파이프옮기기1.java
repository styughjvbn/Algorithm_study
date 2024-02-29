import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n=Integer.parseInt(br.readLine());
        int[][] map=new int[n][n];
        for (int i = 0; i < n; i++) {
            String line=br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j]=line.charAt(j*2)-'0';
            }
        }
        int[][][] dp=new int[n+1][n+1][3];
        dp[1][2][0]=1;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(i==1&&j<=2)continue;
                if(map[i-1][j-1]==1)continue;
                dp[i][j][0]=dp[i][j-1][1]+dp[i][j-1][0];
                if(!(i-2<0 || j-2<0 || map[i-2][j-1]==1 || map[i-1][j-2]==1)){
                    dp[i][j][1]=dp[i-1][j-1][0]+dp[i-1][j-1][2]+dp[i-1][j-1][1];
                }

                dp[i][j][2]=dp[i-1][j][1]+dp[i-1][j][2];
            }
        }

        int sum=dp[n][n][0]+dp[n][n][1]+dp[n][n][2];
        System.out.println(sum);
    }
}