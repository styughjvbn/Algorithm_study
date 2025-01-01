import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int n=Integer.parseInt(br.readLine());
            int[] numbers=new int[10];
            int checkedCount=10;
            int count=0;
            while(true){
                if(checkedCount==0){
                    break;
                }
                count++;
                int tempN=n*count;
//                System.out.println(tempN);
                while(tempN>0){
                    int cur=tempN%10;
                    if(numbers[cur]==0){
                        numbers[cur]=1;
                        checkedCount--;
                    }
                    tempN/=10;
                }
            }
            System.out.printf("#%d %d\n",t+1,count*n);
        }
    }
}