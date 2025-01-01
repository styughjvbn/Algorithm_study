import java.io.*;
import java.util.*;

public class Main{
    static int[] ward;
    static int[] visit;
    static List<Integer>[] edges;
    static int[] areas;
    static int ans=Integer.MAX_VALUE;
    static int totalPopulation;
    public static void sequnce(int depth,int limit,int start){
        if(depth>=limit){
//            System.out.println(Arrays.toString(ward));
            int ward0Index=0;
            int ward1Index=0;
            for (int i = 0; i < ward.length; i++) {
                if (ward[i]==1){
                    ward1Index=i;
                }else{
                    ward0Index=i;
                }
            }
            visit=new int[ward.length];
            visit[ward0Index]=1;
            int ward0Total=check(0,ward0Index);
//            System.out.println(ward0Total);
            visit[ward1Index]=1;
            int ward1Total=check(1,ward1Index);
//            System.out.println(ward1Total);
            if(ward0Total+ward1Total==totalPopulation){
                ans=Math.min(ans,Math.abs(ward0Total-ward1Total));
            }
        }else{
            for (int i = start ; i < ward.length; i++) {
                ward[i]=1;
                sequnce(depth+1,limit,i+1);
                ward[i]=0;
            }
        }
    }

    public static int check(int checkPlag,int cdx){
//        System.out.printf("%d %d\n",cdx,areas[cdx]);
        int sum=areas[cdx];
        for (int i = 0; i < edges[cdx].size(); i++) {
            if(visit[edges[cdx].get(i)]==0 && ward[edges[cdx].get(i)]==checkPlag){
                visit[edges[cdx].get(i)]=1;
                sum+=check(checkPlag,edges[cdx].get(i));
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        areas=new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            areas[i]=Integer.parseInt(st.nextToken());
            totalPopulation+=areas[i];
        }
        edges=new ArrayList[n];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            int limit=Integer.parseInt(st.nextToken());
            edges[i]=new ArrayList<>();
            for (int j = 0; j < limit; j++) {
                edges[i].add(Integer.parseInt(st.nextToken())-1);
            }
        }
        ward=new int[n];

        for (int i = 1; i <= n/2; i++) {
            sequnce(0,i,0);
        }
        if (ans==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }

    }
}