import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] di = new int[]{0,1,0,-1};
    static int[] dj = new int[]{1,0,-1,0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        char[][] maze = new char[n][m];
        for (int i = 0; i < n; i++) {
            maze[i] = br.readLine().toCharArray();
        }
        if( n == 1 && m ==1){
            System.out.println(0);
            return;
        }
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] visit = new int[n][m];
        deque.add(new int[]{0,0,0});
        visit[0][0] = 1;
        while (!deque.isEmpty()) {
            int[] pos = deque.pollFirst();
            for (int k = 0; k < 4; k++) {
                int ni = pos[0] + di[k];
                int nj = pos[1] + dj[k];
                if( ni == n -1  && nj == m - 1){
                    System.out.println(pos[2]);
                    return;
                }
                if (0 <= ni && ni < n && 0 <= nj && nj < m && visit[ni][nj] == 0) {
                    visit[ni][nj] = 1;
                    if(maze[ni][nj] == '0'){
                        deque.addFirst(new int[]{ni,nj,pos[2]});
                    }else{
                        deque.add(new int[]{ni,nj, pos[2]+1});
                    }
                }
            }
        }
    }
}