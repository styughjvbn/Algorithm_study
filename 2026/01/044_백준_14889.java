import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[] visit;
    static int ans=Integer.MAX_VALUE;
    static int[][] values;
    static void dfs(int cdx,int start) {
        if(n/2==cdx) {
            int tema1=0;
            int tema2=0;
            for (int i = 0; i < visit.length; i++) {
                for (int j = 0; j < visit.length; j++) {
                    if(visit[i]==1 && visit[j]==1) {
                        tema1+=values[i][j];
                    }
                    if(visit[i]==0 && visit[j]==0) {
                        tema2+=values[i][j];
                    }
                }
            }
//			System.out.println(Arrays.toString(visit));
//			System.out.println(tema1+" "+tema2);
            ans=Math.min(ans, Math.abs(tema1-tema2));
        }else {
            for (int i = start; i < n; i++) {
                visit[i]=1;
                dfs(cdx+1,i+1);
                visit[i]=0;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        values=new int[n][n];
        visit=new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j = 0; j < values.length; j++) {
                values[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(ans);
    }
}