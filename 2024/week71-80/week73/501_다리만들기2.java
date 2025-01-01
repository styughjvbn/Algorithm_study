import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class UnionFind{
    byte[] parents=new byte[7];
    UnionFind(){
        Arrays.fill(parents,(byte)-1);
    }
    public byte find(byte a){
        if(parents[a]<0){
            return a;
        }else{
            parents[a]=find(parents[a]);
            return parents[a];
        }
    }
    public boolean union(byte a, byte b){
        byte root_a=find(a);
        byte root_b=find(b);
        if(root_a==root_b){
            return false;
        }else{
            if(parents[root_a]<parents[root_b]){
                parents[root_a]+=parents[root_b];
                parents[root_b]=root_a;
            }else{
                parents[root_b]+=parents[root_a];
                parents[root_a]=root_b;
            }
            return true;
        }
    }
}


public class Main {
    static int N,M;
    static byte[][] earth;
    static boolean[][] visit;
    static byte landCount=0;
    static byte[][] bridge=new byte[7][7];
    public static void seperateIsland(int i, int j){
        Deque<int[]> queue=new ArrayDeque<>();
        byte[] di={0,1,0,-1};
        byte[] dj={1,0,-1,0};
        queue.add(new int[]{i,j});
        earth[i][j]=landCount;
        visit[i][j]=true;
        while (!queue.isEmpty()){
            int[] cur=queue.poll();
            for (int k = 0; k < 4; k++) {
                int ni=cur[0]+di[k];
                int nj=cur[1]+dj[k];
                if(0<=ni && ni<N && 0<=nj && nj<M && earth[ni][nj]==1&& !visit[ni][nj]){
                    visit[ni][nj]=true;
                    earth[ni][nj]=landCount;
                    queue.add(new int[]{ni,nj});
                }
            }
        }
    }

    public static void makeBridge(){
        for (int i = 0; i < N; i++) {
            byte start=0;
            byte dis=0;
            for (int j = 0; j < M; j++) {
                if(earth[i][j]==0){
                    dis++;
                    continue;
                };
                if(start!=earth[i][j]){
                    if(start!=0&&dis>1){
                        bridge[start][earth[i][j]]=(byte) Math.min(dis,bridge[start][earth[i][j]]);
                        bridge[earth[i][j]][start]=(byte)Math.min(dis,bridge[earth[i][j]][start]);
                    }
                     start=earth[i][j];
                    dis=0;
                }else{
                    dis=0;
                }
            }
        }
        for (int j = 0; j < M; j++) {
            byte start=0;
            byte dis=0;
            for (int i = 0; i < N; i++) {
                if(earth[i][j]==0){
                    dis++;
                    continue;
                };
                if(start!=earth[i][j]){
                    if(start!=0&&dis>1) {
                        bridge[start][earth[i][j]] = (byte) Math.min(dis, bridge[start][earth[i][j]]);
                        bridge[earth[i][j]][start] = (byte) Math.min(dis, bridge[earth[i][j]][start]);
                    }
                    start=earth[i][j];
                    dis=0;
                }else{
                    dis=0;
                }
            }
        }
    }
    public static void print(){
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(earth[i]));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        earth=new byte[N][M];
        visit=new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                earth[i][j]=Byte.parseByte(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(earth[i][j]==1 && !visit[i][j]){
                    landCount++;
                    seperateIsland(i,j);
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            Arrays.fill(bridge[i],Byte.MAX_VALUE);
        }
        makeBridge();
        PriorityQueue<byte[]> pq=new PriorityQueue<>((a,b)-> a[0]-b[0]);

        for (int i = 1; i < 7; i++) {
            for (int j = i+1; j < 7; j++) {
                if(bridge[i][j]!=Byte.MAX_VALUE){
                    pq.add(new byte[]{bridge[i][j],(byte)i,(byte)j});
                }
            }
        }
//        print();
        UnionFind unionFind=new UnionFind();
        int ans=0;
        for (int i = 0; i < landCount-1;) {
            if(pq.isEmpty()){
                ans=-1;
                break;
            }
            byte[] temp= pq.poll();
            if(unionFind.union(temp[1],temp[2])){
                i++;
                ans+=temp[0];
            }
        }
        System.out.println(ans);
    }
}