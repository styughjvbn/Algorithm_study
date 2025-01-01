import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main
{
    static int[] ingress;
    static List<Integer>[] outgress;

    public static void findPath(int a, List<Integer> path){
        if(ingress[a]!=0){
            findPath(ingress[a]-1,path);
        }
        path.add(ingress[a]);
    }

    public static int findMin(List<Integer> aPath, List<Integer> bPath){
        int commonSize=Math.min(aPath.size(),bPath.size());
        for(int i=0; i<commonSize;i++){
            if(!Objects.equals(aPath.get(i), bPath.get(i))){
                return aPath.get(i-1);
            }
        }
        return aPath.get(commonSize-1);
    }

    public static int calcSubTreeSize(int subRoot){
        Deque<Integer> deque= new ArrayDeque<>();
        deque.add(subRoot-1);
        int count=1;
        while(!deque.isEmpty()) {
            int curNode = deque.poll();
            for (int i : outgress[curNode]) {
                deque.add(i-1);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for (int i=0;i<t ;i++ ){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int v=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            ingress=new int[v];
            outgress=new ArrayList[v];
            for (int i1=0;i1<v ;i1++ ) {
                outgress[i1]=new ArrayList<>();
            }
            st=new StringTokenizer(br.readLine());
            for (int i1=0;i1<e ;i1++ ) {
                int parent=Integer.parseInt(st.nextToken());
                int child=Integer.parseInt(st.nextToken());
                ingress[child-1]=parent;
                outgress[parent-1].add(child);
            }
            List<Integer> aPath=new ArrayList<>();
            List<Integer> bPath=new ArrayList<>();
            findPath(start-1,aPath);
            findPath(end-1,bPath);
            int commonAnc=findMin(aPath,bPath);
            System.out.printf("#%d %d %d\n",i+1,commonAnc,calcSubTreeSize(commonAnc));
        }
    }
}