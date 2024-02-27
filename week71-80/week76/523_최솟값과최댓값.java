import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class segmentTree{
    int[][] tree;
    int[] nums;
    int n;

    public segmentTree(int n,int[] nums) {
        tree=new int[4*n][2];
        this.nums=nums;
        this.n=n;
    }

    public void init(){
        make(0,n-1,1);
    }
    public int[] make(int left, int right,int index){
        if(left==right){
            tree[index][0]=nums[left];
            tree[index][1]=nums[left];
            return tree[index];
        }else{
            int mid=(left+right)/2;
            int[] leftResult=make(left,mid,index*2);
            int[] rightResult=make(mid+1,right,index*2+1);
            tree[index][0]=Math.min(leftResult[0],rightResult[0]);
            tree[index][1]=Math.max(leftResult[1],rightResult[1]);
            return tree[index];
        }
    }

    public int[] getMinMax(int a,int b){
        return calcMinMax(0,n-1,1,a,b);
    }
    private int[] calcMinMax(int left, int right,int index,int a, int b){
        if(right<a || b<left){
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        }
        if(a<=left && right<= b){
            return tree[index];
        }
        int mid=(left+right)/2;
        int[] leftResult=calcMinMax(left,mid,index*2,a,b);
        int[] rightResult=calcMinMax(mid+1,right,index*2+1,a,b);
        int min=Math.min(leftResult[0],rightResult[0]);
        int max=Math.max(leftResult[1],rightResult[1]);
        return new int[]{min,max};
    }
    public void print(){
        System.out.println(Arrays.toString(tree));
    }
}
public class Main{
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=Integer.parseInt(br.readLine());
        }
        segmentTree tree=new segmentTree(n,nums);
        tree.init();
//        tree.print();
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine()," ");
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            int[] result=tree.getMinMax(a,b);
            sb.append(result[0]).append(" ").append(result[1]).append('\n');
        }
        System.out.println(sb);
    }
}