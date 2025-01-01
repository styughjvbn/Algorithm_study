import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int time;
    int i;
    int j;

    Node(int time,int i, int j){
        this.time=time;
        this.i=i;
        this.j=j;
    }
    @Override
    public int compareTo(Node o1) {
        if(o1.time==this.time){
            if(o1.i==this.i){
                return this.j-o1.j;
            }else{
                return this.i-o1.i;
            }

        }else{
            return this.time-o1.time;
        }

    }
}

public class Main{
    static public void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int t1=0;t1<t;t1++){
            int n=Integer.parseInt(br.readLine());
            int[][] world=new int[n][n];
            for (int i = 0; i < n; i++) {
                String line=br.readLine().strip();
                for (int i1 = 0; i1 < n; i1++) {
                    world[i][i1]=(int)line.charAt(i1)-48;
                }
            }
            PriorityQueue<Node> queue=new PriorityQueue<>();
            int[][] dis=new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dis[i][j]=Integer.MAX_VALUE;
                }
            }
            int[] di={0,1,0,-1};
            int[] dj={1,0,-1,0};
            queue.add(new Node(0,0,0));
            dis[0][0]=0;
            while(!queue.isEmpty()){
                Node curNode=queue.poll();
//                System.out.printf("%d %d %d\n",curNode.time,curNode.i,curNode.j);
                if(curNode.time>dis[curNode.i][curNode.j]){
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int ni= curNode.i+di[k];
                    int nj= curNode.j+dj[k];
                    if(0<=ni && ni<n && 0<=nj && nj<n){
                        if(dis[ni][nj]>curNode.time+world[ni][nj]){
                            dis[ni][nj]=curNode.time+world[ni][nj];
                            queue.add(new Node(dis[ni][nj],ni,nj));
                        }
                    }
                }
            }
//            for (int i = 0; i < n; i++) {
//                System.out.println(Arrays.toString(dis[i]));
//            }
            System.out.printf("#%d %d\n",t1+1,dis[n-1][n-1]);
        }
    }
}