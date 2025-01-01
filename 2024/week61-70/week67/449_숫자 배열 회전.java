import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static int[][] rotate90(int[][] arr){
        int[][] newArr=new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr.length; i1++) {
                newArr[i][i1]=arr[arr.length-1-i1][i];
            }
        }
        return newArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st;

            int[][] arr=new int[n][n];
            for (int i1 = 0; i1 < n; i1++) {
                st =new StringTokenizer(br.readLine());
                for (int i2 = 0; i2 < n; i2++) {
                    arr[i1][i2]=Integer.parseInt(st.nextToken());
                }
            }
            int[][] arr90=rotate90(arr);
            int[][] arr180=rotate90(arr90);
            int[][] arr270=rotate90(arr180);
            System.out.printf("#%d\n",i+1);
            for (int i1 = 0; i1 < arr.length; i1++) {
                for (int i2 = 0; i2 < arr.length; i2++) {
                    System.out.print(arr90[i1][i2]);
                }
                System.out.print(" ");
                for (int i2 = 0; i2 < arr.length; i2++) {
                    System.out.print(arr180[i1][i2]);
                }
                System.out.print(" ");
                for (int i2 = 0; i2 < arr.length; i2++) {
                    System.out.print(arr270[i1][i2]);
                }
                System.out.println();
            }
        }
    }
}