import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static int calc(int[] longArr,int[] shortArr){
        int num=0;
        for (int i = 0; i < longArr.length- shortArr.length+1; i++) {
            int tempNum=0;
            for (int i1 = 0; i1 < shortArr.length; i1++) {
                tempNum+=longArr[i+i1]*shortArr[i1];
            }
            if(tempNum>num){
                num=tempNum;
            }
        }
        return num;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int[] arrA=new int[n];
            int[] arrB=new int[m];
            st=new StringTokenizer(br.readLine());
            for (int i1 = 0; i1 < n; i1++) {
                arrA[i1]=Integer.parseInt(st.nextToken());
            }
            st=new StringTokenizer(br.readLine());
            for (int i1 = 0; i1 < m; i1++) {
                arrB[i1]=Integer.parseInt(st.nextToken());
            }
            int result=0;
            if(arrA.length>arrB.length){
                result=calc(arrA,arrB);
            }else{
                result=calc(arrB,arrA);
            }
            System.out.printf("#%d %d\n",i+1,result);
        }
    }
}