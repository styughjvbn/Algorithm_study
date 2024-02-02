import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class SeperateSet{
    int[] parents;

    public SeperateSet(int size) {
        this.parents = new int[size];
        Arrays.fill(parents, -1);
    }

    public boolean union(int a, int b){
        int root_a=find(a);
        int root_b=find(b);
        if(root_b==root_a){
            return false;
        }else{
            if(root_a<root_b){
                parents[root_a]+=parents[root_b];
                parents[root_b]=root_a;
            }else{
                parents[root_b]+=parents[root_a];
                parents[root_a]=root_b;
            }
            return true;
        }
    }
    public int find(int a){
        if(parents[a]<0){
            return a;
        }else{
            parents[a]=find(parents[a]);
            return parents[a];
        }
    }
    public void print(){
        System.out.println(Arrays.toString(parents));
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        SeperateSet seperateSet=new SeperateSet(n);
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            if(!seperateSet.union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))){
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(0);
    }
}