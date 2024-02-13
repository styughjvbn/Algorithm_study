import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int mid;
    static boolean[][] board;
    static int ans=0;
    static int[] positions;
    static void dfs(int depth,int tempAns){
        if(depth>=n*2-1){
            ans=Math.max(ans,tempAns);
//            if(ans<=tempAns){
//                ans=tempAns;
//                System.out.println(Arrays.toString(positions));
//            }
            return;
        }
        int count=mid-(Math.abs(mid-depth)-1);
        boolean isNothing=true;
        for (int j = mid-(count-1),tempCount=0; tempCount<count; j+=2,tempCount++) {
            boolean isOK=true;
            if(!checkBoard(depth,tempCount))continue;
            for (int i = 0; i < depth; i++) {
                if(positions[i]==j){
                    isOK=false;
                    break;
                }
            }
            if(isOK){
                positions[depth]=j;
                isNothing=false;
                dfs(depth+1,tempAns+1);
                positions[depth]=-1;
            }
        }
        if(isNothing){
            dfs(depth+1,tempAns);
        }
//        if(ans<=tempAns){
//            ans=tempAns;
//            System.out.println(Arrays.toString(positions));
//        }
//        ans=Math.max(ans,tempAns);
//        dfs(depth+1,tempAns);

    }

    static boolean checkBoard(int i, int count){
        int boardI=0;
        int boardJ=0;
        if(i>=mid){
            boardI=mid;
            boardJ=i-mid;
        }else{
            boardI=i;
        }
        boardI-=count;
        boardJ+=count;
        return board[boardI][boardJ];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        mid=n-1;
        board=new boolean[n][n];
        positions =new int[n*2-1];
        Arrays.fill(positions,-1);
        for (int i = 0; i < n; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int i1 = 0; i1 < n; i1++) {
                board[i][i1]= st.nextToken().charAt(0) == '1';
            }
        }

        dfs(0,0);
        System.out.println(ans);
    }
}