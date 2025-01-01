import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static StringBuilder sb=new StringBuilder();
    static int[] visit;
    public static void dfs(List<Integer>[] graph,int v){
        sb.append(v+1).append(' ');
        for (Integer i : graph[v]) {
            if(visit[i]==0){
                visit[i]=1;
                dfs(graph,i);
            }
        }
    }
    public static void bfs(List<Integer>[] graph,int start){
        Deque<Integer> queue=new ArrayDeque<>();
        int[] visit=new int[graph.length];
        queue.add(start);
        visit[start]=1;
        sb.append(start+1).append(' ');
        while(!queue.isEmpty()){
            int v=queue.poll();
            for (Integer i : graph[v]) {
                if(visit[i]==0){
                    visit[i]=1;
                    queue.add(i);
                    sb.append(i+1).append(' ');
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int v=Integer.parseInt(st.nextToken())-1;
        List<Integer>[] graph=new List[n];
        for (int i = 0; i < n; i++) {
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            graph[a].add(b);
            graph[b].add(a);
        }
        if(m>1){
            for (List<Integer> integers : graph) {
                integers.sort(Comparator.naturalOrder());
            }
        }

        visit=new int[n];
        visit[v]=1;
        dfs(graph,v);
        sb.append('\n');
        bfs(graph,v);
        System.out.println(sb);
    }
}