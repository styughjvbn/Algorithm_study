import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        boolean[][] map=new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line=br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j]=line.charAt(j)=='1';
            }
        }

        Deque<int[]> deque=new ArrayDeque<>();
        boolean[][] visit=new boolean[n][m];
        visit[0][0]=true;
        deque.add(new int[]{0,0,0});
        int[] di={0,1,0,-1};
        int[] dj={1,0,-1,0};
        int ans=0;
        while (!deque.isEmpty()){
            int[] cur=deque.poll();
            if(cur[0]==n-1 && cur[1]==m-1){
                ans=cur[2];
                break;
            }
            for (int k = 0; k < 4; k++) {
                int ni=cur[0]+di[k];
                int nj=cur[1]+dj[k];
                if(0<=ni && ni<n && 0<=nj && nj<m && map[ni][nj] && !visit[ni][nj]){
                    visit[ni][nj]=true;
                    deque.add(new int[]{ni,nj,cur[2]+1});
                }
            }
        }
        System.out.println(ans+1);
    }
}