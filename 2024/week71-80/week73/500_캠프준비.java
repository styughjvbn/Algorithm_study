import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,L,R,X;
    static int[] levels;
    static int ans;

    public static void dfs(int a, int sum, int min, int max){
        if(a>=N){
            if(L<=sum && sum<=R && max-min>=X){
                ans++;
            }
        }else{
            dfs(a+1,sum+levels[a], Math.min(min, levels[a]),Math.max(max,levels[a]));
            dfs(a+1,sum,min,max);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        levels=new int[N];
        for (int i = 0; i < N; i++) {
            levels[i]=Integer.parseInt(st.nextToken());
        }
        dfs(0,0,Integer.MAX_VALUE,0);
        System.out.println(ans);
    }
}