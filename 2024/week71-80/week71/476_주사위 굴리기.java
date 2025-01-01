import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    static int[][] board;
    static int[][] dice=new int[4][3];
    public static void move(int dir) {
        if(dir==1) {
            int temp=dice[1][0];
            dice[1][0]=dice[3][1];
            dice[3][1]=dice[1][2];
            dice[1][2]=dice[1][1];
            dice[1][1]=temp;
        }else if(dir==2){
            int temp=dice[1][0];
            dice[1][0]=dice[1][1];
            dice[1][1]=dice[1][2];
            dice[1][2]=dice[3][1];
            dice[3][1]=temp;
        }else if(dir==3){
            int temp=dice[0][1];
            dice[0][1]=dice[1][1];
            dice[1][1]=dice[2][1];
            dice[2][1]=dice[3][1];
            dice[3][1]=temp;
        }else if(dir==4){
            int temp=dice[0][1];
            dice[0][1]=dice[3][1];
            dice[3][1]=dice[2][1];
            dice[2][1]=dice[1][1];
            dice[1][1]=temp;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer=new StringTokenizer(bufferedReader.readLine());
        int n=Integer.parseInt(stringTokenizer.nextToken());
        int m=Integer.parseInt(stringTokenizer.nextToken());
        int y=Integer.parseInt(stringTokenizer.nextToken());
        int x=Integer.parseInt(stringTokenizer.nextToken());
        int k=Integer.parseInt(stringTokenizer.nextToken());
        int[][] board=new int[n][m];
        for (int i = 0; i < n; i++) {
            stringTokenizer=new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j]=Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int[] opers=new int[k];
        stringTokenizer=new StringTokenizer(bufferedReader.readLine());
        int[] di={0,0,-1,1};
        int[] dj={1,-1,0,0};
        for (int i = 0; i < opers.length; i++) {
            opers[i]=Integer.parseInt(stringTokenizer.nextToken());
            int nx=x+dj[opers[i]-1];
            int ny=y+di[opers[i]-1];
            if(0<=nx && nx<m && 0<=ny && ny<n) {
                move(opers[i]);
                if(board[ny][nx]==0) {
                    board[ny][nx]=dice[3][1];
                }else {
                    dice[3][1]=board[ny][nx];
                    board[ny][nx]=0;
                }
                System.out.println(dice[1][1]);
                x=nx;
                y=ny;
            }
        }

    }
}