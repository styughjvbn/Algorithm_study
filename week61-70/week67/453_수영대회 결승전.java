import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{

    static class Pos{
        int i;
        int j;
        int sec;
        Pos(int i,int j,int sec){
            this.i=i;
            this.j=j;
            this.sec=sec;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        int[] di={0,1,0,-1};
        int[] dj={1,0,-1,0};

        for (int i = 0; i < t; i++) {
            int n=Integer.parseInt(br.readLine());
            StringTokenizer st;
            int[][] pool=new int[n][n];
            for (int i1 = 0; i1 < n; i1++) {
                st=new StringTokenizer(br.readLine());
                for (int i2 = 0; i2 < n; i2++) {
                    pool[i1][i2]=Integer.parseInt(st.nextToken());
                }
            }
            st=new StringTokenizer(br.readLine());
            Pos start=new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
            st=new StringTokenizer(br.readLine());
            Pos end=new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);

            int[][] visit=new int[n][n];
            Deque<Pos> queue=new ArrayDeque<Pos>();
            queue.add(start);
            visit[start.i][start.j]=1;
            boolean isGoal=false;
            while(!queue.isEmpty()){
                Pos curPos=queue.poll();
                if(curPos.i== end.i && curPos.j== end.j){
                    System.out.printf("#%d %d\n",i+1,curPos.sec);
                    isGoal=true;
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    int ni= curPos.i+di[j];
                    int nj= curPos.j+dj[j];
                    if(0<=ni && ni<n && 0<=nj && nj<n && visit[ni][nj]==0){
                        if(pool[ni][nj]==2){
                            if((curPos.sec+1)%3==0){
                                visit[ni][nj]=1;
                                queue.add(new Pos(ni,nj,curPos.sec+1));
                            }else{
                                queue.add(new Pos(curPos.i, curPos.j, curPos.sec+1));
                            }
                        } else if (pool[ni][nj]==0) {
                            visit[ni][nj]=1;
                            queue.add(new Pos(ni,nj,curPos.sec+1));
                        }
                    }
                }
//                for (int i1 = 0; i1 < visit.length; i1++) {
//                    for (int i2 = 0; i2 < visit.length; i2++) {
//                        System.out.printf("%d ",visit[i1][i2]);
//                    }
//                    System.out.println();
//                }
//                System.out.println();
            }
            if(!isGoal){
                System.out.printf("#%d %d\n",i+1,-1);
            }
        }

    }
}