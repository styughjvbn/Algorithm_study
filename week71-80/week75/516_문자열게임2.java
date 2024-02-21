import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int T= Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str=br.readLine();
            int k=Integer.parseInt(br.readLine());
            List<Integer>[] alpabet=new List[26];
            char[] chatArr=str.toCharArray();
            for (int i1 = 0; i1 < chatArr.length; i1++) {
                int curAlpabet=chatArr[i1]-'a';
                if(alpabet[curAlpabet]==null){
                    alpabet[curAlpabet]=new ArrayList<>();
                }
                alpabet[curAlpabet].add(i1);
            }
            int minLen=10001;
            int maxLen=0;
            for (int i1 = 0; i1 < 26; i1++) {
                if(alpabet[i1]!=null && alpabet[i1].size()>=k){
                    int iter=alpabet[i1].size()-k+1;
                    for (int j = 0; j < iter; j++) {
                        int tempLen=alpabet[i1].get(j+k-1)-alpabet[i1].get(j)+1;
                        minLen=Math.min(minLen,tempLen);
                        maxLen=Math.max(maxLen,tempLen);
                    }
                }
            }
            if(maxLen==0){
                sb.append(-1).append('\n');
            }else{
                sb.append(minLen).append(" ").append(maxLen).append('\n');
            }
        }
        System.out.println(sb);
    }
}
