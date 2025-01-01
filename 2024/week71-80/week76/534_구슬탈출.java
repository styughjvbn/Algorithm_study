import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int m;
    static char[][] map;
    static int[] holePos;
    static int ans=-1;
    public static void main(String[] args) throws IOException {
        st=new StringTokenizer(br.readLine()," ");
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        int[] initRedPos=null;
        int[] initBluePos=null;
        map=new char[n][m];
        for (int i = 0; i < n; i++) {
            String line=br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j]=line.charAt(j);
                if(map[i][j]=='R'){
                    initRedPos=new int[]{i,j};
                    map[i][j]='.';
                }
                if(map[i][j]=='B'){
                    initBluePos=new int[]{i,j};
                    map[i][j]='.';
                }
                if(map[i][j]=='O'){
                    holePos=new int[]{i,j};
                }
            }
        }
        System.out.println(solution(initRedPos,initBluePos));
    }
    static int[] di={0,1,0,-1};
    static int[] dj={1,0,-1,0};
    public static int solution(int[] redPos,int[] bluePos){
        Deque<int[]> deque=new ArrayDeque<>();
        int[][][][] visit=new int[n][m][n][m];
        visit[redPos[0]][redPos[1]][bluePos[0]][bluePos[1]]=1;
        deque.add(new int[]{redPos[0],redPos[1],bluePos[0],bluePos[1]});
        while(!deque.isEmpty()){
            int[] cur=deque.poll();
//            System.out.println(visit[cur[0]][cur[1]][cur[2]][cur[3]]+Arrays.toString(cur));
            if(visit[cur[0]][cur[1]][cur[2]][cur[3]]>10)return -1;
            for (int k = 0; k < 4; k++) {
                int[] nPos=move(new int[]{cur[0],cur[1]},new int[]{cur[2],cur[3]},k);
                if(nPos!=null && visit[nPos[0]][nPos[1]][nPos[2]][nPos[3]]==0){
                    if(nPos[0]==holePos[0] && nPos[1]==holePos[1]){
                       return visit[cur[0]][cur[1]][cur[2]][cur[3]];
                    }
                    visit[nPos[0]][nPos[1]][nPos[2]][nPos[3]]=visit[cur[0]][cur[1]][cur[2]][cur[3]]+1;
                    deque.add(nPos);
                }
            }
        }
        return -1;
    }


    public static int[] move(int[] redPos, int[] bluePos,int dir){

        int[] nextRedPos=moveForward(redPos,dir);
        int[] nextBluePos=moveForward(bluePos,dir);
//        System.out.print(dir+Arrays.toString(redPos)+Arrays.toString(bluePos)+Arrays.toString(nextRedPos)+Arrays.toString(nextBluePos));

        if(dir%2==0&&redPos[0]==bluePos[0]) {//중복 처리를 해줘야할 때
            if (nextRedPos[1] == nextBluePos[1]) {
                if(nextRedPos[0]==holePos[0] && nextRedPos[1]==holePos[1]){
                    return null;
                }
                if (dir == 0) {
                    if (redPos[1] < bluePos[1]) {
                        nextRedPos[1] -= 1;
                    } else {
                        nextBluePos[1] -= 1;
                    }
                } else {
                    if (redPos[1] < bluePos[1]) {
                        nextBluePos[1] += 1;
                    } else {
                        nextRedPos[1] += 1;
                    }
                }
            }
        }else if(dir%2==1&&redPos[1]==bluePos[1]){
            if (nextRedPos[0] == nextBluePos[0]) {
                if(nextRedPos[0]==holePos[0] && nextRedPos[1]==holePos[1]){
                    return null;
                }
                if (dir == 1) {
                    if (redPos[0] < bluePos[0]) {
                        nextRedPos[0] -= 1;
                    } else {
                        nextBluePos[0] -= 1;
                    }
                } else {
                    if (redPos[0] < bluePos[0]) {
                        nextBluePos[0] += 1;
                    } else {
                        nextRedPos[0] += 1;
                    }
                }
            }
        }
        if(nextBluePos[0]==holePos[0] && nextBluePos[1]==holePos[1]){
            return null;
        }
//        System.out.println(Arrays.toString(nextRedPos)+Arrays.toString(nextBluePos));
        return new int[]{nextRedPos[0],nextRedPos[1],nextBluePos[0],nextBluePos[1]};
    }

    public static int[] moveForward(int[] pos, int dir){
        int ni=pos[0];
        int nj=pos[1];
        while(true){
            if(map[ni+di[dir]][nj+dj[dir]]=='.'){
                ni+=di[dir];
                nj+=dj[dir];
            }else{
                if(map[ni+di[dir]][nj+dj[dir]]=='O'){
                    ni+=di[dir];
                    nj+=dj[dir];
                }
                return new int[]{ni,nj};
            }
        }
    }
}