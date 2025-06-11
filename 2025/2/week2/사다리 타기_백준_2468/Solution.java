import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n,k;
    static char[][] ladders;
    static char[] topString;
    static char[] bottomString;


    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        int targetRow = 0;
        ladders = new char[n][k-1];
        topString = new char[k];
        for (int i = 0; i < k; i++) {
            topString[i] = (char)('A' + i);
        }

        bottomString = br.readLine().toCharArray();

        for (int i = 0; i < n; i++) {
            ladders[i] = br.readLine().toCharArray();
            if (ladders[i][0] == '?'){
                targetRow = i;
            }
        }

        for (int i = 0; i < targetRow; i++) {
            climbingLadder(topString, ladders[i]);
        }
        for (int i = n-1; i > targetRow; i--) {
            climbingLadder(bottomString, ladders[i]);
        }
//        System.out.println(Arrays.toString(topString));
//        System.out.println(Arrays.toString(bottomString));
        System.out.println(connectTopBottom());
    }

    static void climbingLadder(char[] orderString, char[] ladderStatus){
        for (int i = 0; i < k-1; i++) {
            if(ladderStatus[i] == '-'){
                char temp = orderString[i+1];
                orderString[i+1] = orderString[i];
                orderString[i] = temp;
                i++;
            }
        }
    }

    static String connectTopBottom(){
        for (int i = 0; i < k-1; i++) {
            if(topString[i]== bottomString[i])
                sb.append('*');
            else{
                if (topString[i + 1] == bottomString[i] && bottomString[i + 1] == topString[i]) {
                    sb.append('-');
                    i++;
                    if (i>=k-1) break;
                    sb.append('*');
                }else{
                    break;
                }
            }
        }
        if (sb.length() != k-1){
//            sb = new StringBuilder();
            for (int i = 0; i < k-1; i++) {
                sb.append('x');
            }
        }
        return sb.toString();
    }
}
