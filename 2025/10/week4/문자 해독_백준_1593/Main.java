import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int g = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        char[] W = br.readLine().toCharArray();
        char[] S = br.readLine().toCharArray();

        int[] upperCase = new int[26];
        int[] lowerCase = new int[26];
        int inCorrectAlpabetCount = 0;
        for (int i = 0; i < g; i++) {
            if(Character.isUpperCase(W[i])){
                upperCase[W[i]-'A']++;
                if(upperCase[W[i]-'A'] == 1)inCorrectAlpabetCount++;
            }else{
                lowerCase[W[i]-'a']++;
                if(lowerCase[W[i]-'a'] == 1)inCorrectAlpabetCount++;
            }
        }

        int ans = 0;

        int[] upperCaseAcc = new int[26];
        int[] lowerCaseAcc = new int[26];
        for (int i = 0; i < s; i++) {
            if(i >= g){
                char deleteChar = S[i-g];
                if(Character.isUpperCase(deleteChar)){
                    upperCaseAcc[deleteChar-'A']--;
                    if(upperCaseAcc[deleteChar-'A']+1 == upperCase[deleteChar-'A'])inCorrectAlpabetCount++;
                }else{
                    lowerCaseAcc[deleteChar-'a']--;
                    if(lowerCaseAcc[deleteChar-'a']+1 == lowerCase[deleteChar-'a'])inCorrectAlpabetCount++;
                }
            }

            char addChar = S[i];
            if(Character.isUpperCase(addChar)){
                upperCaseAcc[addChar-'A']++;
                if(upperCaseAcc[addChar-'A'] == upperCase[addChar-'A'])inCorrectAlpabetCount--;
            }else{
                lowerCaseAcc[addChar-'a']++;
                if(lowerCaseAcc[addChar-'a'] == lowerCase[addChar-'a'])inCorrectAlpabetCount--;
            }

            if(inCorrectAlpabetCount == 0) ans++;
        }
        System.out.println(ans);
    }
}
