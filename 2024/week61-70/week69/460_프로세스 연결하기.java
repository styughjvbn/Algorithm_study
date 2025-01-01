import java.util.*;
import java.lang.*;
import java.io.*;

class Pos{
    int i;
    int j;
    public Pos(int i,int j){
        this.i=i;
        this.j=j;
    }
}

// The main method must be in a class named &quot;Main&quot;.
class Main {
    static int[] visit;
    static	List<Pos> process;
    static int[][] board;
    static int minLen;
    static int maxCoreNum;
    public static void OnBoard(Pos pos,int dir,int amount,boolean isFill){
        int[] di= {0,1,0,-1};
        int[] dj= {1,0,-1,0};
        int i=pos.i;
        int j=pos.j;
        while(amount>0) {
            int ni=i+di[dir];
            int nj=j+dj[dir];
            if(isFill)
                board[ni][nj]=1;
            else
                board[ni][nj]=0;
            i=ni;
            j=nj;
            amount--;
        }
    }//프로세스 선 제거
    public static int checkPutOnBoard(Pos pos,int dir){
        int[] di= {0,1,0,-1};
        int[] dj= {1,0,-1,0};
        int i=pos.i;
        int j=pos.j;
        int len=0;
        while(true) {
            int ni=i+di[dir];
            int nj=j+dj[dir];
            if(0<=ni && ni<board.length && 0<=nj && nj<board.length) {
                if(board[ni][nj]!=0) {
                    return -len;
                }
                i=ni;
                j=nj;
                len++;
            }else {
                break;
            }
        }
        return len;
    }//프로세스 선 놓기

    public static void dfs(int depth,int totalLen,int v){
        if(v==process.size()){
            if(maxCoreNum<depth){
                minLen=totalLen;
                maxCoreNum=depth;
            } else if (maxCoreNum==depth) {
                minLen=Math.min(minLen,totalLen);
            }
            return;
        }

        for (int j = 0; j < 4; j++) {
            int putResult = checkPutOnBoard(process.get(v),j);
            if(putResult>0) {
                OnBoard(process.get(v),j,Math.abs(putResult),true);
                dfs(depth+1,totalLen+putResult,v+1);
                OnBoard(process.get(v),j,Math.abs(putResult),false);
            }
        }
        dfs(depth,totalLen,v+1);
    }//해당 프로세스를 사용하지 않았을 때와 사용했을 때 동서남북으로 선을 놓았을 때 dfs
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(br.readLine().trim());
        for (int t=0;t<T ;t++ ) {
            int n=Integer.parseInt(br.readLine().trim());
            board=new int[n][n];
            process=new ArrayList<>();
            for (int i=0;i<n ;i++ ) {
                st=new StringTokenizer(br.readLine().trim());
                for (int j=0;j<n ;j++ ) {
                    board[i][j]=Integer.parseInt(st.nextToken());
                    if(1<=i && i<n-1 && 1<=j && j<n-1 && board[i][j]==1){
                        process.add(new Pos(i,j));
                    }
                }
            }
            visit=new int[process.size()];
            minLen=Integer.MAX_VALUE;
            maxCoreNum=0;
            dfs(0,0,0);
            System.out.printf("#%d %d\n",t+1, minLen);
        }
    }
}