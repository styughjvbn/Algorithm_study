import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] friendCost = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            friendCost[i] = Integer.parseInt(st.nextToken());
        }
        UnionFind unionFind = new UnionFind(n, friendCost);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken()) - 1;
            unionFind.union(v, w);
        }
        int totalMinFriendCost = unionFind.getTotalMinFriendCost();
        if(totalMinFriendCost>k){
            System.out.println("Oh no");
        }else{
            System.out.println(totalMinFriendCost);
        }
    }
}

class UnionFind{
    private final int[] parents;
    private final int size;
    private final int[] minFriendCost;

    UnionFind(int size, int[] friendCost){
        this.size = size;
        parents = new int[size];
        this.minFriendCost = friendCost;
        Arrays.fill(parents, -1);
    }

    public boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB){
            return false;
        }else{
            if(parents[rootA] < parents[rootB]){
                parents[rootA] += parents[rootB];
                parents[rootB] = rootA;
                minFriendCost[rootA] = Math.min(minFriendCost[rootA], minFriendCost[rootB]);
            }else {
                parents[rootB] += parents[rootA];
                parents[rootA] = rootB;
                minFriendCost[rootB] = Math.min(minFriendCost[rootA], minFriendCost[rootB]);
            }
            return true;
        }
    }

    public int find(int x){
        if(parents[x] < 0){
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    public int getTotalMinFriendCost(){
        int totalMinCost = 0;
        for (int i = 0; i < size; i++) {
            if(parents[i] < 0){
                totalMinCost+=minFriendCost[i];
            }
        }
        return totalMinCost;
    }
}