import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] isEmpty;
    static int[] di={0,1,0,-1};
    static int[] dj={1,0,-1,0};
    static int L;
    static int ans=0;
    public static void check(int[][] map){
        for (int i = 0; i < map.length; i++) {
            boolean isOk=true;
            for (int i1 = 0; i1 < map.length-1; i1++) {
                if(map[i][i1]!=map[i][i1+1]){
                    if(map[i][i1+1]-map[i][i1]==1){//다음 부분이 1만큼 더 높다.
                        isOk=isCanPut(map,2,i,i1+1,map[i][i1]);
                    }else if(map[i][i1+1]-map[i][i1]==-1){//다음 부분이 1만큼 더 낮다.
                        isOk=isCanPut(map,0,i,i1,map[i][i1+1]);
                    }else{
                        isOk=false;
                    }
                }
                if(!isOk)break;
            }
            if(isOk)ans++;
        }
    }
    public static boolean isCanPut(int[][] map,int dir,int i,int j,int ans){
        for (int k = 1; k < L+1; k++) {
            int ni=i+di[dir]*k;
            int nj=j+dj[dir]*k;
            if(!(0<=ni && ni<map.length && 0<=nj && nj<map.length) || isEmpty[ni][nj]==1 || map[ni][nj]!=ans){
                return false;
            }
        }
        for (int k = 1; k < L+1; k++) {
            int ni=i+di[dir]*k;
            int nj=j+dj[dir]*k;
            isEmpty[ni][nj]=1;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        int[][] map1=new int[N][N];
        int[][] map2=new int[N][N];

        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            for (int i1 = 0; i1 < N; i1++) {
                int num=Integer.parseInt(st.nextToken());
                map1[i][i1]=num;
                map2[i1][i]=num;
            }
        }
        isEmpty=new int[N][N];
        check(map1);
        isEmpty=new int[N][N];
        check(map2);
        System.out.println(ans);
    }
}