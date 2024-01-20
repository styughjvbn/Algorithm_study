import java.io.*;
import java.util.*;

class Pos{
    int i;
    int j;
    public Pos(int i, int j) {
        super();
        this.i = i;
        this.j = j;
    }

}

public class Main{
    static int m;
    static List<Pos> chickenHouse=new ArrayList<>();
    static int[] choice;
    static int[][] dis;
    static List<Pos> House=new ArrayList<>();
    static int Ans=Integer.MAX_VALUE;

    static void dfs(int depth,int start) {
        if(depth>=m) {
            int tempAns=0;
            for (int i = 0; i < dis.length; i++) {
                int houseMin=Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    houseMin=Math.min(houseMin, dis[i][choice[j]]);
                }
                tempAns+=houseMin;
            }
            Ans=Math.min(Ans, tempAns);
        }else {
            for (int i = start; i < chickenHouse.size(); i++) {
                choice[depth]=i;
                dfs(depth+1, i+1);
                choice[depth]=0;
            }
        }
    }

    static void calc() {
        for (int i = 0; i < House.size(); i++) {
            Pos housePos=House.get(i);
            for (int j = 0; j < chickenHouse.size(); j++) {
                Pos chickPos=chickenHouse.get(j);
                dis[i][j]=Math.abs(housePos.i-chickPos.i)+Math.abs(housePos.j-chickPos.j);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num=Integer.parseInt(st.nextToken());
                if(num==2) {
                    chickenHouse.add(new Pos(i, j));
                }
                if(num==1) {
                    House.add(new Pos(i, j));
                }
            }
        }
        dis=new int[House.size()][chickenHouse.size()];
        calc();
        choice=new int[m];
        dfs(0, 0);
        System.out.println(Ans);
    }
}