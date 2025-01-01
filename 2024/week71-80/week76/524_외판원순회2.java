import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] weight;
    static int[] visit;
    static int ans=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n=Integer.parseInt(br.readLine());
        weight = new int[n][n];
        visit=new int[n];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine()," ");
            for (int i1 = 0; i1 < n; i1++) {
                weight[i][i1]=Integer.parseInt(st.nextToken());
            }
        }
        visit[0]=1;
        dfs(0,0,0);
        System.out.println(ans);
    }

    public static void dfs(int depth,int value,int prev){
        if(value>ans)return;
        if (depth>=n-1){
            if(weight[prev][0]!=0){
                ans=Math.min(ans,value+weight[prev][0]);
            }
        }else{
            for (int i = 0; i < n; i++) {
                if(weight[prev][i]==0||visit[i]==1)continue;
                visit[i]=1;
                dfs(depth+1,value+weight[prev][i],i);
                visit[i]=0;
            }
        }
    }
}