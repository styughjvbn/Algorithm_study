import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class UnionFind{
        int[] parents;

        public UnionFind(int size) {
            parents=new int[size];
            Arrays.fill(parents,-1);
        }

        public int find(int a){
            if(parents[a]<0){
                return a;
            }else{
                parents[a]=find(parents[a]);
                return parents[a];
            }
        }

        public boolean union(int a, int b){
            int rootA=find(a);
            int rootB=find(b);
            if (rootA==rootB)return false;
            else{
                if(parents[rootA]<parents[rootB]){
                    parents[rootA]+=parents[rootB];
                    parents[rootB]=rootA;
                }else{
                    parents[rootB]+=parents[rootA];
                    parents[rootA]=rootB;
                }
                return true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine()," ");
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        char[] type=new char[n];
        st=new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            type[i]=st.nextToken().charAt(0);
        }
        int[][] edges=new int[m][3];
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine()," ");
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            int c=Integer.parseInt(st.nextToken());
            if(type[a]==type[b])continue;
            edges[i]=new int[]{a,b,c};
        }
        Arrays.sort(edges,(a,b)->{
            return a[2]-b[2];
        });
        UnionFind unionFind = new UnionFind(n);
        int count=0;
        int i=0;
        int ans=0;
        while (count<n-1){
            if(i>=m){
                ans=-1;
                break;
            }
            int[] edge=edges[i];
            if(unionFind.union(edge[0],edge[1])){
                count++;
                ans+=edge[2];
            }
            i++;

        }
        System.out.println(ans);
    }
}