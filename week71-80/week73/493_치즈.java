import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static byte[][] map;
    static byte[][] visit;
    static int cheezeCount=0;
    static Deque<byte[]> queue=new ArrayDeque<>();

    public static void bfs(){
        int[] di={0,1,0,-1};
        int[] dj={1,0,-1,0};

        queue.add(new byte[]{0,0});
        visit[0][0]=1;
        while (!queue.isEmpty()){
            byte[] curPos=queue.poll();
            for (int k = 0; k < 4; k++) {
                byte ni= (byte)(curPos[0]+di[k]);
                byte nj= (byte)(curPos[1]+dj[k]);
                if(0<=ni && ni<map.length && 0<=nj && nj<map[0].length && visit[ni][nj]==0){
                    visit[ni][nj]=1;
                    if(map[ni][nj]==0){
                        queue.add(new byte[]{ni,nj});
                    }else{
                        map[ni][nj]=2;
                    }
                }
            }
        }
    }

    public static int remove(){
        int prevCount=cheezeCount;
        for (int i = 0; i < map.length; i++) {
            for (int i1 = 0; i1 < map[0].length; i1++) {
                if(map[i][i1]==2){
                    map[i][i1]=0;
                    cheezeCount--;
                }
                visit[i][i1]=0;
            }
        }
        return prevCount-cheezeCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        byte a,b;
        a=Byte.parseByte(st.nextToken());
        b=Byte.parseByte(st.nextToken());
        map=new byte[a][b];
        visit=new byte[a][b];
        for (int i = 0; i < a; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < b; j++) {
                map[i][j]=Byte.parseByte(st.nextToken());
                if(map[i][j]==1)cheezeCount++;
            }
        }
        int[] ans={0,0};
        while (cheezeCount>0){
            bfs();
            ans[1]=remove();
            ans[0]++;
        }
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}