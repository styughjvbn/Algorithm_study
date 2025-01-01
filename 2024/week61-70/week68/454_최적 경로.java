import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Pos{
    public int i;
    public int j;
    Pos(int i,int j){
        this.i=i;
        this.j=j;
    }
}

public class Main{
    static int[] visit;
    static Pos[] customers;
    static Pos home;
    public static int dfs(int n,int depth,int dis,int node){
        if(depth==n){
            return dis+calcDis(customers[node],home);
        }else{
            int min_num=Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if(visit[i]==0){
                    visit[i]=1;
                    min_num=Math.min(min_num,dfs(n,depth+1,dis+calcDis(customers[node],customers[i]),i));
                    visit[i]=0;
                }
            }
            return min_num;
        }
    }

    static int calcDis(Pos a,Pos b){
        return Math.abs(a.i- b.i)+Math.abs(a.j- b.j);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());
            Pos company=new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            home=new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            customers=new Pos[n];
            for (int i1 = 0; i1 < n; i1++) {
                customers[i1]=new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            visit=new int[n];
            int result=Integer.MAX_VALUE;
            for (int i1 = 0; i1 < n; i1++) {
                int tempResult=calcDis(company,customers[i1]);
                visit[i1]=1;
                int ddd=dfs(n,1,tempResult,i1);
                result=Math.min(result,ddd);

                visit[i1]=0;
            }
            System.out.printf("#%d %d\n",i+1,result);
        }
    }
}