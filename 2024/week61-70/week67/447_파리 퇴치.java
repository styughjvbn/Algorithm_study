import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
    public static int cross10(int[][] arr, int i,int j,int m){
        int count=0;

        for (int i1 = 0; i1 < m*2-1; i1++) {
            if((j-m+1)+i1>=0 && (j-m+1)+i1< arr.length){
                count+=arr[i][(j-m+1)+i1];
            }
        }

        for (int i1 = 0; i1 < m*2-1; i1++) {
            if((i-m+1)+i1>=0 && (i-m+1)+i1< arr.length){
                count+=arr[(i-m+1)+i1][j];
            }
        }
        count-=arr[i][j];

        return count;
    }

    public static int crossX(int[][] arr, int i,int j,int m){
        int count=0;

        for (int i1 = 0; i1 < m*2-1; i1++) {
            if(((j-m+1)+i1>=0 && (j-m+1)+i1< arr.length)&&((i-m+1)+i1>=0 && (i-m+1)+i1< arr.length)){
                count+=arr[(i-m+1)+i1][(j-m+1)+i1];
            }
        }

        for (int i1 = 0; i1 < m*2-1; i1++) {
            if(((j-m+1)+i1>=0 && (j-m+1)+i1< arr.length)&&((i+m-1)-i1>=0 && (i+m-1)-i1< arr.length)){
                count+=arr[(i+m-1)-i1][(j-m+1)+i1];
            }
        }
        count-=arr[i][j];

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            int n= Integer.parseInt(st.nextToken());
            int m= Integer.parseInt(st.nextToken());

            int result=0;
            int[][] arr=new int[n][n];
            for (int i1 = 0; i1 < n; i1++) {
                st =new StringTokenizer(br.readLine());
                for (int i2 = 0; i2 < n; i2++) {
                    arr[i1][i2]=Integer.parseInt(st.nextToken());
                }
            }
            for (int i1 = 0; i1 < n; i1++) {
                for (int i2 = 0; i2 < n; i2++) {
                    int cross10=cross10(arr,i1,i2,m);
                    int crossX=crossX(arr,i1,i2,m);
                    if (result<cross10){
                        result=cross10;
                    }
                    if (result<crossX){
                        result=crossX;
                    }
                }
            }
            System.out.printf("#%d %d\n",i+1,result);
        }
    }
}