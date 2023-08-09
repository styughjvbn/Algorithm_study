import java.io.*;
import java.util.*;

public class Main{
    static int[] nums;
    public static int find(int a){
        if (nums[a]<0)
            return a;
        else{
            nums[a]=find(nums[a]);
            return nums[a];
        }
    }

    public static void union(int a, int b){
        int find_a=find(a);
        int find_b=find(b);
        if (find_a==find_b)
            return;
        else{
            if (find_a <find_b) {
                nums[find_a]+=nums[find_b];
                nums[find_b]=find_a;
            }else{
                nums[find_b]+=nums[find_a];
                nums[find_a]=find_b;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        nums=new int[n+1];
        for (int i = 0; i <= n; i++) {
            nums[i]=-1;
        }

        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int operand=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(operand==0)
                union(a,b);
            else{
                if(find(a)==find(b)){
                    sb.append("YES\n");
                }
                else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);

    }
}