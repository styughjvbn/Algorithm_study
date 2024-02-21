import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int calc(char operand,char a,int intB){
        int intA=a-'0';
        switch (operand){
            case '+':
                return intB+intA;
            case '-':
                return intB-intA;
            case '*':
                return intA*intB;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line= br.readLine();
            for (int i1 = 0; i1 < n; i1++) {
                board[i][i1]=line.charAt(2*i1);
            }
        }
        int[][][] ans=new int[n][n][2];
        ans[0][0][0]=board[0][0]-'0';
        ans[0][0][1]=board[0][0]-'0';
        for (int i = 0; i < n; i++) {
            for (int i1 = i%2==0?0:1; i1 < n; i1+=2) {
                if(i==0 && i1==0)continue;
                int tempMin=10000;
                int tempMax=-10000;
                if(0<=i-1){
                    if(0<=i1-1){
                        tempMin=Math.min(tempMin,calc(board[i-1][i1],board[i][i1],ans[i-1][i1-1][1]));
                        tempMax=Math.max(tempMax,calc(board[i-1][i1],board[i][i1],ans[i-1][i1-1][0]));
                    }
                    if(0<=i-2){
                        tempMin=Math.min(tempMin,calc(board[i-1][i1],board[i][i1],ans[i-2][i1][1]));
                        tempMax=Math.max(tempMax,calc(board[i-1][i1],board[i][i1],ans[i-2][i1][0]));
                    }
                }
                if(0<=i1-1){
                    if(0<=i-1){
                        tempMin=Math.min(tempMin,calc(board[i][i1-1],board[i][i1],ans[i-1][i1-1][1]));
                        tempMax=Math.max(tempMax,calc(board[i][i1-1],board[i][i1],ans[i-1][i1-1][0]));
                    }
                    if(0<=i1-2){
                        tempMin=Math.min(tempMin,calc(board[i][i1-1],board[i][i1],ans[i][i1-2][1]));
                        tempMax=Math.max(tempMax,calc(board[i][i1-1],board[i][i1],ans[i][i1-2][0]));
                    }
                }
//                System.out.println(tempMax+" "+tempMin);
                ans[i][i1][1]=tempMin;
                ans[i][i1][0]=tempMax;

            }
        }
        System.out.println(ans[n-1][n-1][0]+" "+ans[n-1][n-1][1]);
    }
}
