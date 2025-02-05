import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
            boolean isGroupWord = true;
            HashSet<Character> character = new HashSet<>();
            char[] charArray = br.readLine().toCharArray();

            char prev = charArray[0];
            for (int j = 1; j < charArray.length; j++) {
                if ( character.contains(charArray[j])) {
                    isGroupWord=false;
                    break;
                }
                if (! (prev == charArray[j])) {
                    character.add(prev);
                }

                prev = charArray[j];
            }
            if(isGroupWord)result++;
        }
        System.out.println(result);
    }
}