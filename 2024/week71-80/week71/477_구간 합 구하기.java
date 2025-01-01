//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class SegmentTree{
    long[] nums;
    long[] tree;

    public SegmentTree(long[] nums) {
        this.nums = nums;
        tree=new long[nums.length*4];
        build(0,nums.length-1,1);
    }

    public void build(int start, int end, int node){
        if(start>=end){
            tree[node]=nums[start];
        }else{
            int middle=(start+end)/2;
            build(start,middle,node*2);
            build(middle+1,end,node*2+1);
            tree[node]=tree[node*2]+tree[node*2+1];
        }
    }

    public long calc(int a, int b){
        return query(0, nums.length-1,a,b,1);
    }
    public long query(int start, int end, int wantStart, int wantEnd,int node){
        if(start>wantEnd || end<wantStart){
            return 0;
        }
        if(wantStart<=start && end<=wantEnd){
            return tree[node];
        }
        int middle=(start+end)/2;
        return query(start,middle,wantStart,wantEnd,node*2)+query(middle+1,end,wantStart,wantEnd,node*2+1);
    }

    public void update(int start, int end, int wantNum,long changValue, int node){
        if(start==end){
            tree[node]=changValue;
            return;
        }
        int middle=(start+end)/2;
        if(wantNum<=middle){
            update(start,middle,wantNum,changValue,node*2);
        }else{
            update(middle+1,end,wantNum,changValue,node*2+1);
        }
        tree[node]=tree[node*2]+tree[node*2+1];
    }

    public void print(){
        System.out.println(Arrays.toString(tree));
    }
}

public class Main {
    public static void main(String[] args)  throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        long[] nums=new long[n];
        for (int i = 0; i < n; i++) {
            nums[i]=Long.parseLong(br.readLine());
        }
        SegmentTree segmentTree=new SegmentTree(nums);
        for (int i = 0; i < m+k; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            long c=Long.parseLong(st.nextToken());
            if(a==2){
                System.out.println(segmentTree.calc(b-1,(int)c-1));
            }else{
                segmentTree.update(0, nums.length-1,b-1,c ,1);
            }
        }
    }
}