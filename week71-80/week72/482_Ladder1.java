import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder1 {
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        byte[][] board=new byte[100][100];
        for (int i1 = 0; i1 < 10; i1++) {
            int t=Integer.parseInt(br.readLine());
            for (int i = 0; i < board.length; i++) {
                st=new StringTokenizer(br.readLine());
                for (int j = 0; j < board.length; j++) {
                    board[i][j]=Byte.parseByte(st.nextToken());
                }
            }
            int curX=0;
            for (int i = 0; i < board.length; i++) {
                if(board[board.length-1][i]==2)curX=i;
            }
            for (int i = board.length-2; i >=0; i--) {
                if(curX-1>=0 && board[i][curX-1]==1) {
                    curX-=1;
                    while(true) {
                        if(curX-1>=0 && board[i][curX-1]==1) {
                            curX-=1;
                        }else {
                            break;
                        }
                    }
                }else if(curX+1<board.length && board[i][curX+1]==1) {
                    curX+=1;
                    while(true) {
                        if(curX+1<board.length && board[i][curX+1]==1) {
                            curX+=1;
                        }else {
                            break;
                        }
                    }
                }else {
                    continue;
                }
            }
            System.out.println("#"+t+" "+curX);
        }
    }

}