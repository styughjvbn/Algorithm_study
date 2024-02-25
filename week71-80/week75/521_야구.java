import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class Main{
    static int[][] hitResult;
    static int enning;
    static int[] order=new int[9];
    static int[] visit=new int[9];
    static int ans=0;
    static BaseBallGame baseBallGame=new BaseBallGame();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        enning=Integer.parseInt(br.readLine());
        hitResult=new int[enning][9];
        for (int i = 0; i < enning; i++) {
            String line=br.readLine();
            for (int i1 = 0; i1 < 9; i1++) {
                hitResult[i][i1]=line.charAt(i1*2)-'0';
            }
//            System.out.println(Arrays.toString(hitResult[i]));
        }
        visit[0]=1;
        order[3]=0;
        dfs(0);
        ans=Math.max(ans,baseBallGame.init(order));
        System.out.println(ans);
//        int[] temp=new int[]{1,2,3,0,4,5,6,7,8};
//        baseBallGame.init(temp);
//        for (int i = 0; i < enning; i++) {
//            System.out.println(enning+"start");
//            baseBallGame.play(hitResult[i]);
//        }
//        System.out.println(baseBallGame.init(temp));
    }

    static int num=0;
    public static void dfs(int depth){
        if(depth==3){
            dfs(depth+1);
        }else{
            if(depth>=9){
                ans=Math.max(ans,baseBallGame.init(order));
                for (int i = 0; i < enning; i++) {
                    baseBallGame.play(hitResult[i]);
                }
//                System.out.println(Arrays.toString(order));
//                num++;
            }else{
                for (int i = 0; i < 9; i++) {
                    if(visit[i]==1)continue;
                    order[depth]=i;
                    visit[i]=1;
                    dfs(depth+1);
                    visit[i]=0;
                }
            }
        }

    }
}

class BaseBallGame{
    int hitter;
    int out;
    int[] order;
    int score;
    int[] base;
    int baseStart;

    public int init(int[] order){
        hitter=0;

        int returnScore=score;
        score=0;

        this.order=order;
        return returnScore;
    }
    public void play(int[] hitResult){
        out=0;
        base=new int[4];
        baseStart=0;
        for (int i = 0;; i++) {

            int player=order[hitter];
//            System.out.println("플레이어 "+player+" "+out);
            if (hitResult[player]==0){

                if(out()){
                    hitter=(hitter+1)%9;
                    return;
                }
            }else {
                hit(hitResult[player]);
            }
            hitter=(hitter+1)%9;
        }
    }
    public void hit(int amount){
        base[(baseStart+4)%4]=1;
        for (int i = 0; i < amount; i++) {
            baseStart=(baseStart+1)%4;
            if(base[baseStart]==1){
                score++;
            }
            base[baseStart]=0;
        }
    }
    public boolean out(){
        out++;
        return out >= 3;
    }
}