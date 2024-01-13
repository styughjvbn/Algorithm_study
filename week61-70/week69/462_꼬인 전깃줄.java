import java.io.*;
import java.util.*;

class LIS{
    private int[] array;
    private int curLen;
    public LIS(int maxLen) {
        array=new int[maxLen+1];
        Arrays.fill(array, Integer.MIN_VALUE);
        curLen=1;
    }

    public int getLIS() {
        return curLen-1;
    }

    public void updateDP(int num) {
        int len=binarySearch(num);
        if(array[len]==num) {
            return;
        }
        if(len==curLen) {
            array[curLen++]=num;
        }else {
            array[len]=Math.min(array[len], num);
        }
    }

    private int binarySearch(int a) {
        int low=0;
        int high=curLen-1;
        int middle;
        while(true) {
            middle=(high+low)/2;
            if(low>high) {
                return middle+1;
            }
            if(array[middle]==a) {
                return middle;
            }else if(array[middle]>a) {
                high=middle-1;
            }else {
                low=middle+1;
            }
        }
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int[] nums=new int[n];
        LIS lis=new LIS(n);
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i]=Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < nums.length; i++) {
            lis.updateDP(nums[i]);
        }
        System.out.println(n-lis.getLIS());
    }
}