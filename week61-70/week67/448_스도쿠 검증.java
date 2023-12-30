import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static boolean check3x3(int[][] arr){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[] num=new int[9];
                for (int i2 = 0; i2 < 3; i2++) {
                    for (int i1 = 0; i1 < 3; i1++) {
                        if(num[arr[i2+(i*3)][i1+(j*3)]-1]==1){
                            return false;
                        }
                        num[arr[i2+(i*3)][i1+(j*3)]-1]=1;
                    }
                }
            }
        }

        return true;
    }
    public static boolean checkCross(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            int[] num=new int[9];
            for (int i1 = 0; i1 < arr.length; i1++) {
                if(num[arr[i1][i]-1]==0){
                    num[arr[i1][i]-1]=1;
                }
                else{
                    return false;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int[] num=new int[9];
            for (int i1 = 0; i1 < arr.length; i1++) {
                if(num[arr[i][i1]-1]==0){
                    num[arr[i][i1]-1]=1;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st;

            int[][] arr=new int[9][9];
            for (int i1 = 0; i1 < 9; i1++) {
                st =new StringTokenizer(br.readLine());
                for (int i2 = 0; i2 < 9; i2++) {
                    arr[i1][i2]=Integer.parseInt(st.nextToken());
                }
            }
            int result=0;
            if(checkCross(arr)&&check3x3(arr)){
                result=1;
            }
            System.out.printf("#%d %d\n",i+1,result);
        }
    }
}