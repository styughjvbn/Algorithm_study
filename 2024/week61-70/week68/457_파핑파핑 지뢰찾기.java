import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main{
    static class Pos{
        int i;
        int j;
        Pos(int i,int j){
            this.i=i;
            this.j=j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n=Integer.parseInt(br.readLine());
            char[][] board=new char[n][n];
            for (int i1 = 0; i1 < n; i1++) {
                String line= br.readLine();
                for (int i2 = 0; i2 < n; i2++) {
                    board[i1][i2]=line.charAt(i2);
                }
            }
            int[][] num=new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(board[j][k]=='*'){
                        num[j][k]=-1;
                        continue;
                    }

                    int count=0;
                    for (int l = -1; l < 2; l++) {
                        for (int m = -1; m < 2; m++) {
                            int y=j+l;
                            int x=k+m;
                            if(y>=0 && y<n && x>=0 && x<n && board[y][x]=='*'){
                                count++;
                            }
                        }
                    }
                    num[j][k]=count;
                }
            }

            int[][] visit=new int[n][n];
            int[] di={0,1,1,1,0,-1,-1,-1};
            int[] dj={1,1,0,-1,-1,-1,0,1};
            int clickNum=0;
            for (int i1 = 0; i1 < num.length; i1++) {
                for (int i2 = 0; i2 < num.length; i2++) {
                    if(num[i1][i2]==0 && visit[i1][i2]==0){
                        clickNum++;
                        Deque<Pos> deque=new ArrayDeque<>();
                        deque.add(new Pos(i1,i2));
                        num[i1][i2]=-1;
                        while(!deque.isEmpty()){
                            Pos curPos=deque.poll();
                            for (int i3 = 0; i3 < 8; i3++) {
                                int ni= curPos.i+di[i3];
                                int nj= curPos.j+dj[i3];
                                if(0<=ni && ni<n && 0<=nj && nj<n && visit[ni][nj]==0 && num[ni][nj]!=-1){
                                    if(num[ni][nj]==0){
                                        deque.add(new Pos(ni,nj));
                                    }
                                    num[ni][nj]=-1;
                                    visit[ni][nj]=clickNum;
                                }
                            }
                        }
                    }
                }
            }
            for (int i1 = 0; i1 < n; i1++) {
                for (int i2 = 0; i2 < n; i2++) {
                    if(num[i1][i2]!=-1){
                        clickNum++;
                    }
                }
            }
            System.out.printf("#%d %d\n",i+1,clickNum);
        }
    }
}