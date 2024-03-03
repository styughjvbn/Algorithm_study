import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static int[][] basePaper=new int[10][10];
    static int ans=25;
    static int[] remainPaper={5,5,5,5,5};
    public static void main(String[] args)throws IOException {
        int remainHole=0;
        for (int i = 0; i < 10; i++) {
            String line=br.readLine();
            for (int j = 0; j < 10; j++) {
                basePaper[i][j]=line.charAt(j*2)-'0';
                if(basePaper[i][j]==1){
                    remainHole++;
                }
            }
        }
        dfs(0,0,0,remainHole);
        System.out.println(ans==25?-1:ans);
    }

    public static void dfs(int depth,int startI, int startJ,int remainHole){
        if((startI>=10)|| depth>=ans){
            return;
        }
        if(remainHole<=0){
            ans= depth;
            return;
        }
        if(startJ>=10){
            dfs(depth,startI+1,0,remainHole);
            return;
        }
        if(basePaper[startI][startJ]==1){
            int availablePaperRange=isCanPut(startI,startJ);
            for (int k = availablePaperRange-1; k >= 0; k--) {
                if(remainPaper[k]==0)continue;
                int range=k+1;
                reversePaper(startI,startJ,range,0);
                remainPaper[k]--;
                dfs(depth+1,startI,startJ+range,remainHole-range*range);
                remainPaper[k]++;
                reversePaper(startI,startJ,range,1);
            }
        }else{
            dfs(depth,startI,startJ+1,remainHole);
        }
//        for (int j = startJ; j < 10; j++) {
//
//        }
//        for (int i = startI+1; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                if(basePaper[i][j]==1){
//                    int availablePaperRange=isCanPut(i,j);
//                    for (int k = availablePaperRange-1; k >= 0; k--) {
//                        if(remainPaper[k]==0)continue;
//                        int range=k+1;
//                        reversePaper(i,j,range,0);
//                        remainPaper[k]--;
//                        dfs(depth+1,i,j+range,remainHole-range*range);
//                        remainPaper[k]++;
//                        reversePaper(i,j,range,1);
//                    }
//                }
//            }
//        }
    }
    public static void reversePaper(int targetI, int targetJ, int range,int target){
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < range; j++) {
                basePaper[targetI+i][targetJ+j]=target;
            }
        }
    }
    public static int isCanPut(int targetI, int targetJ){
        for (int k = 0; k < 5; k++) {
            int i=targetI;
            int j=targetJ+k;
            if(j>=10 || i+k>=10)return k;
            for (int col = 0; col < k; col++) {
                if(basePaper[i][j]==0){
                    return k;
                }
                i++;
            }
            if(basePaper[i][j]==0){
                return k;
            }
            for (int row = 0; row < k; row++) {
                j--;
                if(basePaper[i][j]==0){
                    return k;
                }
            }
        }
        return 5;
    }
}