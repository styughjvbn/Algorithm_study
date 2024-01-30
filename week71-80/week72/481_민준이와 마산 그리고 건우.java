import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge{
    int next;
    int weight;
    public Edge(int next, int weight) {
        super();
        this.next = next;
        this.weight = weight;
    }
}

class Vertex implements Comparable<Vertex>{
    int id;
    int curWeight;
    public Vertex(int id, int curWeight) {
        super();
        this.id = id;
        this.curWeight = curWeight;
    }
    @Override
    public int compareTo(Vertex o) {
        // TODO Auto-generated method stub
        return this.curWeight-o.curWeight;
    }
}
public class Main {
    public static int[] dijsktra(List<Edge>[] edges,int start) {
        PriorityQueue<Vertex> pq=new PriorityQueue<>();
        int[] dp=new int[edges.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        dp[start]=0;
        pq.add(new Vertex(start, 0));
        while(!pq.isEmpty()) {
            Vertex curVertex=pq.poll();
            if(curVertex.curWeight>dp[curVertex.id]) {
                continue;
            }
            for (int i = 0; i <edges[curVertex.id].size() ; i++) {
                Edge edge=edges[curVertex.id].get(i);
                if(edge.weight+dp[curVertex.id]<dp[edge.next]) {
                    dp[edge.next]=edge.weight+dp[curVertex.id];
                    pq.add(new Vertex(edge.next, dp[edge.next]));
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int V=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());
        int P=Integer.parseInt(st.nextToken());
        List<Edge>[] edges=new ArrayList[V];
        for (int i = 0; i < edges.length; i++) {
            edges[i]=new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            edges[a-1].add(new Edge(b-1, c));
            edges[b-1].add(new Edge(a-1, c));
        }
        int[] basePath=dijsktra(edges,0);
        int[] gunwooPath=dijsktra(edges,P-1);
        int minimalPathWeight=basePath[V-1];
        int gunwooPathWeight=gunwooPath[V-1]+gunwooPath[0];
        if(gunwooPathWeight<=minimalPathWeight) {
            System.out.println("SAVE HIM");
        }else {
            System.out.println("GOOD BYE");
        }
//		System.out.println(Arrays.toString(dijsktra(edges,3)));

    }
}
