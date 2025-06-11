import java.util.*;
import java.io.*;

class Solution{
    static class UnionFind{
        int[] rootRank;

        UnionFind(int n) {
            rootRank = new int[n+1];
            Arrays.fill(rootRank,-1);
        }

        int find(int a) {
            if (rootRank[a] < 0) {
                return a;
            }
            rootRank[a] = find(rootRank[a]);
            return rootRank[a];
        }

        boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootB == rootA) {
                return false;
            }
            if (rootRank[rootA] < rootRank[rootB]) {
                rootRank[rootA] += rootRank[rootB];
                rootRank[rootB] = rootA;
            }else{
                rootRank[rootB] += rootRank[rootA];
                rootRank[rootA] = rootB;
            }
            return true;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = st.nextToken().charAt(0) - '0';
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (type == 1) {
                if (unionFind.find(a) == unionFind.find(b)) {
                    sb.append("yes").append("\n");
                }else{
                    sb.append("no").append("\n");
                }
            }else{
                unionFind.union(a, b);
            }
        }
        System.out.println(sb);
    }

}