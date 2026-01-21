import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[] nums;
    static int minAns=Integer.MAX_VALUE;
    static int maxAns=Integer.MIN_VALUE;

    public static void dfs(int cdx, int value,int plus,int minus, int mul,int div) {
//		System.out.println(cdx +" "+ value+" "+ plus+" "+ minus+" "+  mul+" "+ div);
        if(cdx>=n-1) {
            minAns=Math.min(minAns, value);
            maxAns=Math.max(maxAns, value);
        }else {
            if(plus>0) {
                dfs(cdx+1, value+nums[cdx+1], plus-1, minus, mul, div);
            }
            if(minus>0) {
                dfs(cdx+1, value-nums[cdx+1], plus, minus-1, mul, div);
            }
            if(mul>0) {
                dfs(cdx+1, value*nums[cdx+1], plus, minus, mul-1, div);
            }
            if(div>0) {
                dfs(cdx+1, value/nums[cdx+1], plus, minus, mul, div-1);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        int[] operator=new int[4];
        for (int i = 0; i < 4; i++) {
            operator[i]=Integer.parseInt(st.nextToken());
        }
        dfs(0,nums[0], operator[0], operator[1], operator[2],operator[3]);
        System.out.println(maxAns);
        System.out.println(minAns);
    }
}