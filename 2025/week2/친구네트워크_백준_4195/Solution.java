import java.util.*;
import java.io.*;

class Solution{
    static class UnionFind{
        int size;
        int[] rootRank;
        HashMap<String, Integer> nameToId = new HashMap<>();
        List<String> idToName = new ArrayList<>();
        UnionFind(int size){
            this.size = size;
            rootRank = new int[size];
            Arrays.fill(rootRank, -1);
        }

        int allocateName(String name){
            if(nameToId.containsKey(name)) return nameToId.get(name);
            nameToId.put(name, idToName.size());
            idToName.add(name);
            return idToName.size()-1;
        }

        int find(int a){
            if (rootRank[a] < 0) return a;

            rootRank[a] = find(rootRank[a]);
            return rootRank[a];
        }

        int union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return rootRank[rootA];

            if (rootRank[rootA] > rootRank[rootB]){
                rootRank[rootB] += rootRank[rootA];
                rootRank[rootA] = rootB;
                return rootRank[rootB];
            }else{
                rootRank[rootA] += rootRank[rootB];
                rootRank[rootB] = rootA;
                return rootRank[rootA];
            }
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        int testCast = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCast; i++) {
            int n = Integer.parseInt(br.readLine());
            UnionFind unionFind = new UnionFind(n*2);
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int nameAId = unionFind.allocateName(st.nextToken());
                int nameBId = unionFind.allocateName(st.nextToken());
                sb.append(unionFind.union(nameAId,nameBId)*-1).append('\n');
            }
        }
        System.out.println(sb);
    }
}