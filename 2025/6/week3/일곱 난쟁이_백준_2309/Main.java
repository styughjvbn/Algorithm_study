import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] tempHeights = new int[7];
    static int[] heights = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        combination(0,0,0);
    }

    public static void combination(int depth, int i, int sum){
        if(depth >= 7){
            if(sum == 100){
                Arrays.sort(tempHeights);
                for (int tempHeight : tempHeights) {
                    System.out.println(tempHeight);
                }
                System.exit(0);
            }
            return;
        }

        for(int j = i; j < 9; j++){
            tempHeights[depth] = heights[j];
            combination(depth + 1, j + 1, sum + heights[j]);
        }
    }
}