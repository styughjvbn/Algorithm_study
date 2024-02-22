import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static List<Integer>[] vertex;
    static int[] parent;
    static int[] depth;
    static int maxDepth;
    static int[] visit;
    static int[][] dp;
    public static int LCA(int a, int b){
        //둘중에 하나라도 루트노드라면 최소 공통부모는 루트
        if(a==0 || b==0)return 0;

        //a를 깊이가 더 깊은 노드로 고정
        if(depth[a]<=depth[b]){
            int temp=a;
            a=b;
            b=temp;
        }

        for (int i = dp[0].length-1; i >= 0 ; i--) {
            if(depth[dp[a][i]]>=depth[b]){
                a=dp[a][i];
            }
        }

        if(a==b)return a;
        for (int i = dp[0].length-1; i >= 0; i--) {
            if(dp[a][i]!=dp[b][i]){
                a=dp[a][i];
                b=dp[b][i];
            }
        }

        return dp[a][0];
    }
    public static void init(int root,int n){
        depth=new int[n];
        parent=new int[n];
        visit=new int[n];
        visit[root]=1;
        dfs(root,0);
        maxDepth=(int)Math.ceil(Math.log(n) / Math.log(2)) + 1;
        dp=new int[n][maxDepth];

        for (int i = 0; i < n; i++) {
            dp[i][0]=parent[i];
        }


        for (int i = 1; i < maxDepth; i++) {
            for (int j = 0; j < n; j++) {
                dp[j][i]=dp[dp[j][i-1]][i-1];
            }
        }
    }

    public static void dfs(int v, int vDepth){
        maxDepth=Math.max(maxDepth,vDepth);
        depth[v]=vDepth;
        for (Integer i : vertex[v]) {
            if(visit[i]==1)continue;
            visit[i]=1;
            parent[i]=v;
            dfs(i,vDepth+1);
        }
    }

    public static void print(){
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(depth));
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        vertex=new List[n];
        for (int i = 0; i < n; i++) {
            vertex[i]=new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            st=new StringTokenizer(br.readLine()," ");
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            vertex[a].add(b);
            vertex[b].add(a);
        }
        init(0,n);
//        print();
        StringBuilder sb= new StringBuilder();
        int m=Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine()," ");
            sb.append(LCA(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1)+1).append('\n');
        }
        System.out.println(sb);
    }
}