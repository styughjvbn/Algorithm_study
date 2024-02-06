import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int[] sushi=new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i]=Integer.parseInt(br.readLine());
        }
        Map<Integer,Integer> map=new HashMap<>();
        map.put(c,1);
        for (int i = 0; i < k; i++) {
            map.merge(sushi[i],1,Integer::sum);
        }
        int ans=map.keySet().size();
        int start=0;
        int end=k;
        for (int i = 0; i < N-1; i++) {
            if(map.get(sushi[start])==1){
                map.remove(sushi[start]);
            }else{
                map.put(sushi[start], map.get(sushi[start])-1 );
            }
            map.merge(sushi[end],1,Integer::sum);
            start=(start+1)%N;
            end=(end+1)%N;
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                System.out.println(entry.getKey()+" "+entry.getValue());
//            }
//            System.out.println();
            ans=Math.max(ans,map.keySet().size());
        }
        System.out.println(ans);
    }
}