import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pos{
    int i;
    int j;

    public Pos(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
public class Main {
    static int[][] board;
    static int[][] opers;
    static int[] visit;
    static int ans=Integer.MAX_VALUE;
    public static void rotate(Pos start,Pos end,boolean reverse){
        int changeNum=(end.i-start.i)*4;
        int[] nums=new int[changeNum];
        int[] di={0,1,0,-1};
        int[] dj={1,0,-1,0};
        int ni=start.i;
        int nj=start.j;
        int index=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < end.i-start.i; j++) {
                ni+=di[i];
                nj+=dj[i];
                nums[index]=board[ni][nj];
                index++;
            }
        }
        ni=start.i;
        nj=start.j;
        if(reverse){
            index=1;
        }else{
            index=changeNum-1;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < end.i-start.i; j++) {
                ni+=di[i];
                nj+=dj[i];
                board[ni][nj]=nums[index];
                index=(index+1)%changeNum;
            }
        }
    }

    public static void print(){
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[0].length; i1++) {
                System.out.print(board[i][i1]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void calcValue(){
        int temp=Integer.MAX_VALUE;
        for (int[] ints : board) {
            int sum=0;
            for (int anInt : ints) {
                sum+=anInt;
            }
            temp=Math.min(temp,sum);
        }
        ans=Math.min(temp,ans);
    }
    public static void operateRotate(int r, int c, int s,boolean reverse){
        for (int i = 1; i <= s; i++) {
            rotate(new Pos(r-i,c-i),new Pos(r+i,c+i),reverse);
        }
    }
    public static void dfs(int depth){
        if(depth>=opers.length){
            calcValue();
        }else{
            for (int i = 0; i < opers.length; i++) {
                if(visit[i]!=0)continue;
                visit[i]=1;
                operateRotate(opers[i][0],opers[i][1],opers[i][2],false);
                dfs(depth+1);
                visit[i]=0;
                operateRotate(opers[i][0],opers[i][1],opers[i][2],true);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N,M,K;
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        board=new int[N][M];
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            for (int i1 = 0; i1 < M; i1++) {
                board[i][i1]=Integer.parseInt(st.nextToken());
            }
        }
        opers=new int[K][3];
        visit=new int[K];
        for (int i = 0; i < K; i++) {
            st=new StringTokenizer(br.readLine());
            opers[i][0]=Integer.parseInt(st.nextToken())-1;
            opers[i][1]=Integer.parseInt(st.nextToken())-1;
            opers[i][2]=Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(ans);
    }
}
