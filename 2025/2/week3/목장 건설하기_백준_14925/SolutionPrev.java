import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class SolutionPrev{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] ground = new int[n][m];
        int[][] prefixGround = new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                prefixGround[i+1][j+1] = ground[i][j] + prefixGround[i+1][j] + prefixGround[i][j+1] - prefixGround[i][j];
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = res; i-k >= 0 && j-k >= 0; k++) {
                    int temp = prefixGround[i][j] + prefixGround[i-k][j-k] - prefixGround[i-k][j] - prefixGround[i][j-k];
                    if (temp == 0 ){
                        res = k;
                    }else {
                        break;
                    }
                }
            }
        }
        System.out.println(res);
    }
}