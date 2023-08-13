import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int V=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        int K=Integer.parseInt(st.nextToken())-1;

        ArrayList<Node>[] graph=new ArrayList[V];
        for(int i=0; i<V; i++) {
            graph[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < E; i++) {
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken())-1;
            int v=Integer.parseInt(st.nextToken())-1;
            int w=Integer.parseInt(st.nextToken());
            graph[u].add(new Node(w,v));
        }
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[K]=0;
        PriorityQueue<Node> queue=new PriorityQueue<>();
        queue.offer(new Node(0,K));

        while(!queue.isEmpty()){
            Node node=queue.poll();
            if (dist[node.u]<node.w){
                continue;
            }
            for (int i = 0; i < graph[node.u].size(); i++) {
                if(dist[graph[node.u].get(i).u]> node.w+graph[node.u].get(i).w){
                    dist[graph[node.u].get(i).u]=node.w+graph[node.u].get(i).w;
                    queue.offer(new Node(node.w+graph[node.u].get(i).w,graph[node.u].get(i).u));
                }
            }
        }

        for (int j : dist) {
            if (j == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(j);
            }
        }
    }
    static class Node implements Comparable<Node>{
        int u;
        int w;

        Node(int w, int u){
            this.u=u;
            this.w=w;
        }

        @Override
        public int compareTo(Node node) {
            return this.w-node.w;
        }
    }
}