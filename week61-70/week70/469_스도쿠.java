import java.io.*;
import java.util.*;

class Pos{
    int i;
    int j;

    public Pos(int i, int j) {
        this.i = i;
        this.j = j;
    }

}

public class Main{
    static int[][] board=new int[9][9];
    static List<Pos> holeList=new ArrayList<>();

    public static boolean dfs(int depth) {
//		System.out.println(depth);
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board.length; j++) {
//				System.out.print(board[i][j]+" ");
//			}
//			System.out.println();
//		}
        if(depth>=holeList.size()) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            return true;
        }else {
            Pos pos=holeList.get(depth);
            for (int num = 0; num < 9; num++) {
                if(check(pos.i, pos.j, num+1)) {
                    board[pos.i][pos.j]=num+1;
                    if(dfs(depth+1))return true;
                    board[pos.i][pos.j]=0;
                }
            }
            return false;
        }

    }

    public static boolean check(int i, int j,int num) {
        int baseI=(i/3)*3;
        int baseJ=(j/3)*3;
        for (int k = 0; k < board.length; k++) {
            if(board[i][k]==num || board[k][j]==num || board[baseI+(k/3)][baseJ+k%3]==num) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        for (int i = 0; i < 9; i++) {
            stringTokenizer=new StringTokenizer(bReader.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j]=Integer.parseInt(stringTokenizer.nextToken());
                if(board[i][j]==0) {
                    holeList.add(new Pos(i, j));
                }
            }
        }

        dfs(0);
    }
}