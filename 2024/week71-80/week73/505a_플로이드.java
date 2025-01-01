import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] dijckstra(int a,List<int[]>[] edges){
        PriorityQueue<int[]> pq=new PriorityQueue<>((a1,b1)->a1[1]-b1[1]);
        int[] dis=new int[edges.length];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[a]=0;
        pq.add(new int[]{a,0});
        while (!pq.isEmpty()){
            int[] cur=pq.poll();
            if(cur[1]>dis[cur[0]])continue;
            for (int[] o : edges[cur[0]]) {
                if(dis[o[0]]>dis[cur[0]]+o[1]){
                    dis[o[0]]=dis[cur[0]]+o[1];
                    pq.add(new int[]{o[0],dis[o[0]]});
                }

            }
        }
        return dis;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        List<int[]>[] edges=new ArrayList[n];
        for (int i = 0; i < edges.length; i++) {
            edges[i]=new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine()," ");
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            edges[a-1].add(new int[]{b-1,c});
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < n; i++) {
            int[] temp=dijckstra(i,edges);
            for (int i1 : temp) {
                if(i1==Integer.MAX_VALUE){
                    sb.append(0);
                }else{
                    sb.append(i1);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}