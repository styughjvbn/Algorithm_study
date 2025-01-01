//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pos{
    int i;
    int j;

    public Pos(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main {
    static int[][] board;
    static int n;
    static int m;
    static int[] di={0,1,0,-1};
    static int[] dj={1,0,-1,0};
    static int ans=0;
    static int[][] visit;

    public static void dfs(int depth,int value, Pos curPos){
        if(depth>=4){
            ans=Math.max(ans,value);
        }else{
            for (int k = 0; k < 4; k++) {
                int ni=curPos.i+di[k];
                int nj=curPos.j+dj[k];
                if(0<=ni && ni<n && 0<=nj && nj<m && visit[ni][nj]==0){
                    visit[ni][nj]=1;
                    dfs(depth+1,value+board[ni][nj],new Pos(ni,nj));
                    visit[ni][nj]=0;
                }
            }
        }
    }

    public static void check10(Pos curPos,int value){
        int[] check={-1,-1,-1,-1};
        int checkNum=0;
        int sum=0;
        for (int k = 0; k < 4; k++) {
            int ni=curPos.i+di[k];
            int nj=curPos.j+dj[k];
            if(0<=ni && ni<n && 0<=nj && nj<m){
                checkNum++;
                check[k]=board[ni][nj];
                sum+=board[ni][nj];
            }
        }
        if(checkNum<=2)return;
        else if (checkNum==3)ans=Math.max(ans,value+sum);
        else{
            for (int i = 0; i < 4; i++) {
                ans=Math.max(ans,value+sum-check[i]);
            }
        }

    }

    public static void main(String[] args)  throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        board=new int[n][m];
        visit=new int[n][m];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int i1 = 0; i1 < m; i1++) {
                board[i][i1]=Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < m; i1++) {
                visit[i][i1]=1;
                dfs(1,board[i][i1],new Pos(i,i1));
                visit[i][i1]=0;
                check10(new Pos(i,i1),board[i][i1]);
            }
        }
        System.out.println(ans);
    }
}