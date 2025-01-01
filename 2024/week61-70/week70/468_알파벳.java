import java.io.*;
import java.util.*;

public class Main{
    static int[] alpabet=new int[26];
    static char[][] board;
    static int[] di= {0,1,0,-1};
    static int[] dj= {1,0,-1,0};
    static int ans=1;

    public static void dfs(int depth,int i,int j) {
        for (int k = 0;k < 4; k++) {
            int ni=i+di[k];
            int nj=j+dj[k];
            if(0<=ni && ni<board.length && 0<=nj && nj<board[0].length && alpabet[board[ni][nj]-'A']==0) {
                alpabet[board[ni][nj]-'A']=1;
                dfs(depth+1,ni,nj);
                alpabet[board[ni][nj]-'A']=0;
            }
        }
        ans=Math.max(ans, depth);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        board=new char[n][m];
        for (int i = 0; i < n; i++) {
            String line=br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j]=line.charAt(j);
            }
        }
        alpabet[board[0][0]-'A']=1;
        dfs(1, 0, 0);
        System.out.println(ans);
    }
}