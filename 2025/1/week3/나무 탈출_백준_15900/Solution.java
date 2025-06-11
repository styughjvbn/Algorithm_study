import java.util.*;
import java.io.*;

class Solution{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] edges = new List[n];
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            if(edges[a] == null) edges[a] = new ArrayList<>();
            if(edges[b] == null) edges[b] = new ArrayList<>();
            edges[a].add(b);
            edges[b].add(a);
        }
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[] visit = new boolean[n];
        visit[0] = true;
        deque.add(new int[]{0, 0});
        int stepCount = 0;
        while(!deque.isEmpty()){
            int[] vertex = deque.pollFirst();
            boolean isLeaf = true;
            for (Integer i : edges[vertex[0]]) {
                if(visit[i])continue;
                deque.add(new int[]{i, vertex[1]+1});
                visit[i] = true;
                isLeaf = false;
            }
            if (isLeaf) stepCount+=vertex[1];
        }
        if (stepCount%2 == 0) System.out.println("No");
        else System.out.println("Yes");
    }
}