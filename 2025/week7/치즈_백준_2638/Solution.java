import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n,m;
    static char[][] grid;
    static int[][] visit;
    static int visitFlag = 0;
    static int[] di = new int[]{0,1,0,-1};
    static int[] dj = new int[]{1,0,-1,0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new char[n][m];
        visit = new int[n][m];
        int cheeseSize = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = st.nextToken().charAt(0);
                if (grid[i][j] == '1') {
                    cheeseSize++;
                }
            }
        }

        Deque<int[]> queue = new ArrayDeque<>();

        while (cheeseSize > 0){
            queue.add(new int[]{0, 0});
            visit[0][0] = ++visitFlag;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int ni = cur[0] + di[k];
                    int nj = cur[1] + dj[k];
                    if (0<=ni && ni < n && 0<=nj && nj <m) {
                        if (visit[ni][nj] != visitFlag){
                            visit[ni][nj] = visitFlag;
                            if(grid[ni][nj] == '0')
                                queue.add(new int[]{ni, nj});
                        }else{
                            if(grid[ni][nj] == '1'){
                                grid[ni][nj] = '0';
                                cheeseSize--;
                            }
                        }
                    }
                }
            }
            time++;
        }
        System.out.println(time);
    }
}