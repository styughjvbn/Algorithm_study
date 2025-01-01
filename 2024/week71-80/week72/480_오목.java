import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static byte[][] board;
    public static boolean check(int i, int j) {
        // 8방향중 오른쪽상단으로 뻗는 대각선, 오른쪽 수평, 오른쪽하단으로 뻗는 대각선, 아래쪽 수직 방향만 체크
        byte[] di= {-1,0,1,1};
        byte[] dj= {1,1,1,0};
        for (int k = 0; k < dj.length; k++) {
            int ni=i;
            int nj=j;

            int checkNum=0;
            for (int k2 = 0; k2 < 4; k2++) {
                ni+=di[k];
                nj+=dj[k];
                if(0<=ni && ni<19 && 0<=nj && nj<19) {
                    if(board[ni][nj]==board[i][j]) {
                        checkNum++;
                    }
                }
            }

            if(checkNum==4) {
                boolean isWin=true;
                int ni1=i-di[k];
                int nj1=j-dj[k];
                if(0<=ni1 && ni1<19 && 0<=nj1 && nj1<19) {
                    if(board[ni1][nj1]==board[i][j]) {
                        isWin=false;
                    }
                }
                ni1=i+di[k]*5;

                nj1=j+dj[k]*5;
                if(0<=ni1 && ni1<19 && 0<=nj1 && nj1<19) {
                    if(board[ni1][nj1]==board[i][j]) {
                        isWin=false;

                    }
                }
                if(isWin)return isWin;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("Test5.txt"));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board=new byte[19][19];
        for (int i = 0; i < board.length; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < board.length; j++) {
                board[i][j]=Byte.parseByte(st.nextToken());
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]!=0) {
                    if(check(i,j)) {
                        System.out.println(board[i][j]);
                        System.out.printf("%d %d\n",i+1,j+1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
}

