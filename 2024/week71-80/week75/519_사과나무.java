import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] orchard=new int[n+1][n+1];
        StringTokenizer st;
        for (int i = 1; i <=n; i++) {
            st=new StringTokenizer(br.readLine()," ");
            for (int j = 1; j <= n; j++) {
                int num=Integer.parseInt(st.nextToken());
                orchard[i][j]=orchard[i-1][j]+orchard[i][j-1]-orchard[i-1][j-1]+num;
            }
        }

        int result=Integer.MIN_VALUE;
        for (int k = 0; k <= n-1; k++) {
            for (int i = 1; i <= n-k; i++) {
                for (int j = 1; j <= n-k; j++) {
                    int sum=orchard[i+k][j+k]-orchard[i-1][j+k]-orchard[i+k][j-1]+orchard[i-1][j-1];
                    result=Math.max(result,sum);
                }
            }
        }
        System.out.println(result);

    }
}