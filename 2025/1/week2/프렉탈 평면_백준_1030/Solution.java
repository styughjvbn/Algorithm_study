import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{
    static int s;
    static int n;
    static int k;
    static int r1;
    static int r2;
    static int c1;
    static int c2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        s = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[1][1];//false white, true black
        int prevR = 0;
        int prevC = 0;
        for (int i = 0; i <= s; i++) {
//            for (int p = 0; p < map.length; p++) {
//                System.out.println(Arrays.toString(map[p]));
//            }
//            System.out.println("\n");
            int tempR1 = (int)Math.floor(r1/Math.pow(n,s-i));
            int tempR2 = (int)Math.floor(r2/Math.pow(n,s-i));
            int tempC1 = (int)Math.floor(c1/Math.pow(n,s-i));
            int tempC2 = (int)Math.floor(c2/Math.pow(n,s-i));
            int sizeR = tempR2 - tempR1 + 1;
            int sizeC = tempC2 - tempC1 + 1;
            if(i == s){
                for (int r = 0; r < sizeR; r++) {
                    for (int c = 0; c < sizeC; c++) {
                        if(map[tempR1 + r-prevR*n][tempC1 + c-prevC*n]){
                            sb.append("1");
                        }else{
                            sb.append("0");
                        }
                    }
                    sb.append('\n');
                }
                System.out.println(sb);
                return;
            }
//            System.out.printf("%d %d %d %d %d %d\n",tempR1, tempR1, tempC1, tempC2, sizeR, sizeC);
            boolean[][] newMap = new boolean[sizeR*n][sizeC*n];

            for (int r = 0; r < sizeR; r++) {
                for (int c = 0; c < sizeC; c++) {
                    color(newMap, r*n,c*n, map[tempR1 + r-prevR*n][tempC1 + c-prevC*n]);
                }
            }

            map = newMap;
            prevR = tempR1;
            prevC = tempC1;
        }

    }

    static void color(boolean[][] map, int targetI, int targetJ, boolean black){
        if(black){
            for (int i = targetI; i < targetI+n; i++) {
                for (int j = targetJ; j < targetJ+n; j++) {
                    map[i][j] = true;
                }
            }
        }else{
            int tmpI = targetI+(n-k)/2;
            for (int i = 0; i < k; i++) {
                int tmpJ=targetJ+(n-k)/2;
                for (int j = 0; j < k; j++) {
                    map[tmpI][tmpJ] = true;
                    tmpJ++;
                }
                tmpI++;
            }
        }
    }
}