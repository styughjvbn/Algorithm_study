import java.io.*;
import java.util.*;

class Solution{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    static int n,m;
    static UnionFind unionFind;
    static PriorityQueue<int[]> connectionCost;
    static HashSet<Integer> connectedNetworks;
    static int connectedCount = 0;
    static int minimumCost = 0;
    static int pairNum = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        connectionCost = new PriorityQueue<int[]>((o1, o2) -> {
            if(o1[0]==o2[0])return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        connectedNetworks = new HashSet<>();

        unionFind = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            connectedNetworks.add(x*1_000+y);
            if(unionFind.union(x, y))connectedCount++;
        }

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j ++){
                int cost = Integer.parseInt(st.nextToken());
                if(j == 0)continue;
                int intHash = i*1_000+j;
                if(connectedNetworks.contains(intHash))continue;
                
                connectionCost.add(new int[]{cost,intHash});
            }
        }

        while (!connectionCost.isEmpty()) {
            int[] node = connectionCost.poll();
            int x = node[1]/1_000;
            int y = node[1]%1_000;
            if(unionFind.union(x, y)){
                minimumCost+=node[0];
                pairNum+=1;
                sb.append(x+1).append(" ").append(y+1).append('\n');
                connectedCount++;
            }
            if(connectedCount>=n-2)break;
        }
        System.out.println(""+minimumCost+" "+pairNum);
        System.out.println(sb);
    }
}

class UnionFind{
    int size = 0;
    int[] parentRank;

    public UnionFind(int size){
        this.size = size;
        parentRank = new int[size];
        Arrays.fill(parentRank, -1);
    }

    public int find(int x){
        if(parentRank[x] < 0) return x;
        return parentRank[x] = find(parentRank[x]);
    }

    public boolean union(int x, int y){
        int xRoot = find(x);
        int yRoot = find(y);
        if(xRoot == yRoot) return false;
        if(parentRank[xRoot] > parentRank[yRoot]){
            parentRank[yRoot] += parentRank[xRoot];
            parentRank[xRoot] = yRoot;
        }else{
            parentRank[xRoot] += parentRank[yRoot];
            parentRank[yRoot] = xRoot;
        }
        return true;
    }
}