import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class SeperateSet{
    int[] elements;
    public SeperateSet(int size){
        elements=new int[size];
        Arrays.fill(elements,-1);
    }
    public int find(int a){
        if(elements[a]<0){
            return a;
        }else{
            elements[a]=find(elements[a]);
            return elements[a];
        }
    }

    public boolean union(int a,int b){
        int root_a=find(a);
        int root_b=find(b);
        if(elements[root_a]<-1000 && elements[root_b]<-1000)return false;
        if(root_a==root_b){
            return false;
        }else{
            if(elements[root_a]<elements[root_b]){
                elements[root_a]+=elements[root_b];
                elements[root_b]=root_a;
            }else{
                elements[root_b]+=elements[root_a];
                elements[root_a]=root_b;
            }
        }
        return true;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N,M,K;
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        int[] generater=new int[K];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            generater[i]=Integer.parseInt(st.nextToken())-1;
        }
        List<int[]>[] edges=new List[N];
        for (int i = 0; i < N; i++) {
            edges[i]=new ArrayList<int[]>();
        }
        for (int i = 0; i < M; i++) {
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            edges[u-1].add(new int[]{v-1,w});
            edges[v-1].add(new int[]{u-1,w});
        }

        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->{
            if(a[2]==b[2]){
                return a[0]-b[0];
            }
            return a[2]-b[2];
        });
        SeperateSet seperateSet=new SeperateSet(N);
        for (int i = 0; i < K; i++) {
            for (int[] temp:edges[generater[i]]) {
                queue.add(new int[]{generater[i],temp[0],temp[1]});
            }
            seperateSet.elements[generater[i]]=-1001;
        }
        int havaToLink=N-K;
        int ans=0;
        while(havaToLink>0){
            int[] min= queue.poll();

            if(seperateSet.union(min[0],min[1])){
//                System.out.println((min[0]+1)+" "+(min[1]+1)+" "+min[2]);
//                System.out.println(Arrays.toString(seperateSet.elements));
                for (int[] temp:edges[min[1]]) {
                    queue.add(new int[]{min[1],temp[0],temp[1]});
                }
                havaToLink--;
                ans+=min[2];
            }
        }
        System.out.println(ans);
    }
}