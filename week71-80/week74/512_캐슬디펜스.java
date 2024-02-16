import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N;
    static int M;
    static int D;
    static int[][] baseBoard;
    static int[][] board;
    static int[] position;
    static int[][] visit;

    static void swap(int a, int b){
        int temp=position[a];
        position[a]=position[b];
        position[b]=temp;
    }
    static boolean np(){
        int i= position.length-1;
        while(i>0 && position[i-1]>=position[i])i--;

        if(i==0)return false;

        int j= position.length-1;
        while(position[i-1]>=position[j])j--;

        swap(i-1,j);
        int k= position.length-1;
        while(i<k)swap(i++,k--);

        return true;
    }

    static int play(){
        int flag=1;
        int sum=0;
        for (int i = 0; i < N; i++) {
            int[][] kill=new int[3][];
            int index=0;
            for (int j = 0; j < M; j++) {
                if(position[j]==1){
                    kill[index++]=bfs(i,j,flag++);
                }
            }
            for (int j = 0; j < 3; j++) {
                if(kill[j]==null)continue;
                if(board[kill[j][0]][kill[j][1]]==1){
//                    System.out.println("잡음 "+kill[j][0]+" "+kill[j][1]);
                    board[kill[j][0]][kill[j][1]]=0;
                    sum++;
                }

            }
        }
        return sum;
    }

    static int[] di={0,1,0};
    static int[] dj={-1,0,1};
    static int[] bfs(int i, int j, int flag){
        Deque<int[]> queue=new ArrayDeque<>();
        queue.add(new int[]{i-1,j,1});
        while (!queue.isEmpty()){
            int[] cur=queue.poll();
            for (int k = 0; k < 3; k++) {
                int ni=cur[0]+di[k];
                int nj=cur[1]+dj[k];
                if(i<=ni && ni<N && 0<=nj && nj<M && visit[ni][nj]!=flag){
//                    System.out.println(ni+" "+nj+" "+flag);
                    if(board[ni][nj]==1){
                        return new int[]{ni,nj};
                    }
                    if(cur[2]+1>D)continue;
                    visit[ni][nj]=flag;
                    queue.add(new int[]{ni,nj,cur[2]+1});
                }
            }
        }
        return null;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());
        baseBoard=new int[N][M];
        position=new int[M];
        for (int i = M-1; i >M-4 ; i--) {
            position[i]=1;
        }
        for (int i = N-1; i >=0 ; i--) {
            String line=br.readLine();
            for (int i1 = 0; i1 < M; i1++) {
                baseBoard[i][i1]=line.charAt(i1*2)-'0';
            }
        }
        int ans=0;
        do{
            visit=new int[N][M];
            board=new int[N][];
            for (int i = 0; i < N; i++) {
                board[i]=Arrays.copyOf(baseBoard[i],M);
            }
//            for (int i = 0; i < M; i++) {
//                if (position[i] == 1) {
//                    System.out.print(i + " ");
//                }
//            }
//            System.out.println("=========");
            int temp=play();
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(board[i]));
//            }
            ans=Math.max(ans,temp);
//            System.out.println();
//            System.out.println(temp);
        }while(np());
        System.out.println(ans);
    }
}