import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int i;
    int j;
    int team;

    public Node(int i, int j, int team) {
        this.i = i;
        this.j = j;
        this.team = team;
    }
}

public class Main {
    public static boolean bfs(int[][] earth,int L, int R){
        int[] di={0,1,0,-1};
        int[] dj={1,0,-1,0};
        int[][] team=new int[earth.length][earth.length];
        int[][] teamTotal=new int[earth.length* earth.length+1][2];
        int teamCount=0;

        for (int i = 0; i < earth.length; i++) {
            for (int i1 = 0; i1 < earth.length; i1++) {
                if(team[i][i1]==0){
                    teamCount++;
                    Deque<Node> queue=new ArrayDeque<>();
                    queue.add(new Node(i,i1,teamCount));
                    team[i][i1]=teamCount;
                    teamTotal[teamCount][0]+=earth[i][i1];
                    teamTotal[teamCount][1]+=1;
                    while (!queue.isEmpty()){
                        Node curNode=queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int ni= curNode.i+di[k];
                            int nj= curNode.j+dj[k];
                            if(0<=ni && ni<earth.length && 0<=nj && nj<earth.length && team[ni][nj]==0){
                                int gap=Math.abs(earth[ni][nj]-earth[curNode.i][curNode.j]);
                                if(L<=gap && gap<=R){
                                    team[ni][nj]= curNode.team;
                                    queue.add(new Node(ni,nj, curNode.team));
                                    teamTotal[curNode.team][0]+=earth[ni][nj];
                                    teamTotal[curNode.team][1]+=1;
                                }
                            }
                        }
                    }
                }
            }
        }

        if(teamCount== earth.length* earth.length){
            return false;
        }
        for (int i = 0; i < earth.length; i++) {
            for (int i1 = 0; i1 < earth.length; i1++) {
                earth[i][i1]=teamTotal[team[i][i1]][0]/teamTotal[team[i][i1]][1];
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        int R=Integer.parseInt(st.nextToken());
        int[][] earth=new int[N][N];
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            for (int i1 = 0; i1 < N; i1++) {
                earth[i][i1]=Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 2000; i++) {
            if(!bfs(earth,L,R)){
                System.out.println(i);
                return;
            }
        }
    }
}