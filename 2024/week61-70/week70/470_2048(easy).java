package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int ans=0;

    static void dfs(int depth,int[][] curBoard) {
        if(depth>=5) {
            ans= Math.max(ans, searchMax(curBoard));
        }else {
            for (int i = 0; i < 4; i++) {
                dfs(depth+1, move(i, curBoard));
            }
        }
    }

    static int searchMax(int[][] curBoard) {
        int maxNum=0;
        for (int i = 0; i < curBoard.length; i++) {
            for (int j = 0; j < curBoard.length; j++) {
                maxNum=Math.max(maxNum, curBoard[i][j]);
            }
        }

        return maxNum;
    }

    static int[][] move(int dir,int[][] curBoard) {
        int[][] newBoard=new int[n][n];
        boolean isMoved=false;
        if(dir==1) {
            for (int i = 0; i < n; i++) {
                int index=n-1;
                int prevValue=0;
                for (int j = n-1; j >=0; j--) {
                    if(curBoard[j][i]==0)continue;
                    if(curBoard[j][i]==prevValue) {
                        newBoard[index][i]=prevValue*2;
                        prevValue=0;
                        index--;
                    }else {
                        if(prevValue!=0) {
                            newBoard[index][i]=prevValue;
                            index--;
                        }
                        prevValue=curBoard[j][i];
                    }
                }
                if(prevValue!=0) {
                    newBoard[index][i]=prevValue;
                }
            }
        }else if(dir==0) {
            for (int i = 0; i < n; i++) {
                int index=n-1;
                int prevValue=0;
                for (int j = n-1; j >=0; j--) {
                    if(curBoard[i][j]==0)continue;
                    if(curBoard[i][j]==prevValue) {
                        newBoard[i][index]=prevValue*2;
                        prevValue=0;
                        index--;
                    }else {
                        if(prevValue!=0) {
                            newBoard[i][index]=prevValue;
                            index--;
                        }
                        prevValue=curBoard[i][j];
                    }
                }
                if(prevValue!=0) {
                    newBoard[i][index]=prevValue;
                }
            }
        } else if (dir==2) {
            for (int i = 0; i < n; i++) {
                int index=0;
                int prevValue=0;
                for (int j = 0; j <n; j++) {
                    if(curBoard[i][j]==0)continue;
                    if(curBoard[i][j]==prevValue) {
                        newBoard[i][index]=prevValue*2;
                        prevValue=0;
                        index++;
                    }else {
                        if(prevValue!=0) {
                            newBoard[i][index]=prevValue;
                            index++;
                        }
                        prevValue=curBoard[i][j];
                    }
                }
                if(prevValue!=0) {
                    newBoard[i][index]=prevValue;
                }
            }
        }else if (dir==3) {
            for (int i = 0; i < n; i++) {
                int index=0;
                int prevValue=0;
                for (int j = 0; j <n; j++) {
                    if(curBoard[j][i]==0)continue;
                    if(curBoard[j][i]==prevValue) {
                        newBoard[index][i]=prevValue*2;
                        prevValue=0;
                        index++;
                    }else {
                        if(prevValue!=0) {
                            newBoard[index][i]=prevValue;
                            index++;
                        }
                        prevValue=curBoard[j][i];
                    }
                }
                if(prevValue!=0) {
                    newBoard[index][i]=prevValue;
                }
            }
        }
        return newBoard;
    }
    static void print(int[][] curBoard) {
        for (int i = 0; i < curBoard.length; i++) {
            System.out.println(Arrays.toString(curBoard[i]));
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        n=Integer.parseInt(bufferedReader.readLine());
        int[][] board=new int[n][n];
        for (int i = 0; i < n; i++) {
            stringTokenizer=new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j]=Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        dfs(0, board);
//		print(move(1, board));
        System.out.println(ans);
    }

}