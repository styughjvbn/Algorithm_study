import java.util.*;
import java.io.*;

class Solution{
    static class UnionFind{
        int size;
        int[] rootRank;
        UnionFind(int size){
            this.size = size;
            rootRank = new int[size];
            Arrays.fill(rootRank, -1);
        }

        int find(int a){
            if (rootRank[a] < 0) return a;

            rootRank[a] = find(rootRank[a]);
            return rootRank[a];
        }

        boolean union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return false;

            if (rootRank[rootA] > rootRank[rootB]){
                rootRank[rootB] += rootRank[rootA];
                rootRank[rootA] = rootB;
            }else{
                rootRank[rootA] += rootRank[rootB];
                rootRank[rootB] = rootA;
            }
            return true;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        int testCast = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCast; i++) {
            sb.append("Scenario ").append(i).append(":\n");
            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());
            UnionFind unionFind = new UnionFind(n);
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                unionFind.union(a,b);
            }
            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(unionFind.find(a) == unionFind.find(b)){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                sb.append('\n');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}