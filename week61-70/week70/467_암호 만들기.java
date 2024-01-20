import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder stringBuilder=new StringBuilder();
    static int n;
    static int m;
    static char[] charcter;
    static char[] password;

    public static void dfs(int dpeth,int start,int consonant, int vowel ) {
        if(dpeth>=n) {
            if(consonant>=1 && vowel>=2) {
                for (int i = 0; i < password.length; i++) {
                    stringBuilder.append(password[i]);
                }
                stringBuilder.append('\n');
            }
        }else {
            for (int i = start; i < charcter.length; i++) {
                password[dpeth]=charcter[i];
                if(charcter[i]=='a'||charcter[i]=='e'||charcter[i]=='i'||charcter[i]=='o'||charcter[i]=='u') {
                    dfs(dpeth+1, i+1,consonant+1,vowel);
                }else {
                    dfs(dpeth+1, i+1,consonant,vowel+1);
                }

            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        charcter=new char[m];
        for (int i = 0; i < m; i++) {
            charcter[i]=st.nextToken().charAt(0);
        }
        Arrays.sort(charcter);
        password=new char[n];
        dfs(0, 0, 0, 0);
        System.out.println(stringBuilder.toString());
    }
}