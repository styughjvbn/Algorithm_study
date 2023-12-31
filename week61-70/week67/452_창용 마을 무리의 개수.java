import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
    static int[] node;
    public static int find(int a){
        if(node[a]<0){
            return a;
        }
        node[a]=find(node[a]);
        return node[a];
    }

    public static void union(int a, int b){
        int root_a=find(a);
        int root_b=find(b);
        if(root_a==root_b){
            return;
        }
        if (node[root_a]<node[root_b]){
            node[root_a]+=node[root_b];
            node[root_b]=root_a;
        }else{
            node[root_b]+=node[root_a];
            node[root_a]=root_b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            node=new int[n];
            for (int i1 = 0; i1 < n; i1++) {
                node[i1]=-1;
            }
            for (int i2 = 0; i2 < m; i2++) {
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken())-1;
                int b=Integer.parseInt(st.nextToken())-1;
                union(a,b);
            }
            HashSet result=new HashSet<>();
            for (int i1 = 0; i1 < n; i1++) {
                result.add(find(i1));
            }
            System.out.printf("#%d %d\n",i+1,result.size());
        }
    }
}