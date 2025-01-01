import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] visit;
    static int[] nums;
    static int[] permutaion;
    static int ans;
    public static void dfs(int a){
        if(a>=nums.length){
            int temp=0;
            for (int i = 1; i < permutaion.length; i++) {
                temp+=Math.abs(permutaion[i-1]-permutaion[i]);
            }
            
            ans=Math.max(ans,temp);
        }else{
            for (int i = 0; i < nums.length; i++) {
                if(visit[i]==1)continue;
                permutaion[a]=nums[i];
                visit[i]=1;
                dfs(a+1);
                visit[i]=0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        nums=new int[n];
        visit=new int[n];
        permutaion=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(ans);
    }
}