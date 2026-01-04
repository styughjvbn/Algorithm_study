import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n,m;

        st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st .nextToken());
        m = Integer.parseInt(st .nextToken());
        int[][] table = new  int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //2차원 누적합 계산
        int[][] preifx2d = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                preifx2d[i+1][j+1] = table[i][j] + preifx2d[i][j + 1] + preifx2d[i + 1][j] - preifx2d[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x1 =  Integer.parseInt(st.nextToken());
            int y1 =  Integer.parseInt(st.nextToken());
            int x2 =  Integer.parseInt(st.nextToken());
            int y2 =  Integer.parseInt(st.nextToken());
            sb.append(preifx2d[x2][y2] -preifx2d[x1 - 1][y2] - preifx2d[x2][y1 - 1] + preifx2d[x1-1][y1-1]).append('\n');
        }

        System.out.println(sb);

    }
}
