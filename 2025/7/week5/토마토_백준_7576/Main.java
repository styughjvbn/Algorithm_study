import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] di = new int[]{0, 1, 0, -1};
    static int[] dj = new int[]{1, 0, -1, 0};
    static int n,m;
    static int[][] box;
    static int[][] visit;
    static int unripeTomatoCount = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];
        visit = new int[n][m];


        Deque<int[]> deque = new ArrayDeque<>();
        for(int i =0; i< n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 0) unripeTomatoCount++;
                if(box[i][j] == 1) {
                    deque.add(new int[]{i, j, 0});
                    visit[i][j] = 1;
                }
            }
        }

        if(unripeTomatoCount == 0){
            System.out.println(0);
            return;
        }

        int days = 0;
        while (!deque.isEmpty()) {
            int[] posInfo = deque.pollFirst();
            for (int k = 0; k < 4; k++) {
                int ni = posInfo[0] + di[k];
                int nj = posInfo[1] + dj[k];
                if (0 <= ni && ni < n && 0 <= nj && nj < m) {
                    if(visit[ni][nj] == 0 && box[ni][nj] == 0){
                        visit[ni][nj] = 1;
                        unripeTomatoCount--;
                        deque.add(new int[]{ni, nj, posInfo[2]+1});
                    }
                }
            }
            days = posInfo[2];
        }

        if(unripeTomatoCount != 0) System.out.println(-1);
        else System.out.println(days);
    }
}