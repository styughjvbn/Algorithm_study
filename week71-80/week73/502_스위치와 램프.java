import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        Map<Integer,Integer> map=new HashMap<>();
        int[][] swi=new int[n][];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            int k=Integer.parseInt(st.nextToken());
            int[] temp=new int[k];
            for (int i1 = 0; i1 < k; i1++) {
                temp[i1]=Integer.parseInt(st.nextToken());
                map.merge(temp[i1],1,Integer::sum);
            }
            swi[i]=temp;
        }
        byte ans=1;
        for (int i = 0; i < n; i++) {
            boolean isOK=true;
            for (int j :swi[i]) {
                if(map.get(j)==1){
                    isOK=false;
                    break;
                }
            }
            if(isOK){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}