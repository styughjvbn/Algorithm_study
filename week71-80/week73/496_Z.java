import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int order=0;
    static int r;
    static int c;
    static int ans;
    public static void dfs(int i, int j, int dis){
        if(dis==1){
            order++;
            if(r==i && c==j){
                ans=order;
            }
        }else{
            dis=dis/2;
            if(i<=r && r<i+dis && j<=c && c<j+dis){
                dfs(i,j,dis);
            }else{
                order+=dis*dis;
            }
            if(i<=r && r<i+dis && j+dis<=c && c<j+dis+dis){
                dfs(i,j+dis,dis);
            }else{
                order+=dis*dis;
            }
            if(i+dis<=r && r<i+dis+dis && j<=c && c<j+dis){
                dfs(i+dis,j,dis);
            }else{
                order+=dis*dis;
            }
            if(i+dis<=r && r<i+dis+dis && j+dis<=c && c<j+dis+dis){
                dfs(i+dis,j+dis,dis);
            }else{
                order+=dis*dis;
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        dfs(0,0,1<<N);
        System.out.println(ans-1);
    }
}