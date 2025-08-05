import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        UnionFind unionFind = new UnionFind(1_000_000);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char instruction = st.nextToken().charAt(0);
            if (instruction == 'I') {
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                unionFind.union(a, b);
            }else{
                int c = Integer.parseInt(st.nextToken()) - 1;
                int root = unionFind.find(c);

                sb.append(unionFind.getElementCount(root)).append('\n');
            }
        }
        System.out.println(sb);
    }
}

class UnionFind{
    private final int[] parents;
    private final int size;

    UnionFind(int size){
        this.size = size;
        parents = new int[size];
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
            }else {
                parents[rootB] += parents[rootA];
                parents[rootA] = rootB;
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

    public int getElementCount(int x){
        return parents[x] * -1;
    }
}