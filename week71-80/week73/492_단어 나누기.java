import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] seperater=new int[2];
    static String ans="zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
    static String inputString;
    public static void dfs(int index, int start){
        if(index>=2){
            StringBuilder a=new StringBuilder(inputString.substring(0,seperater[0]));
            StringBuilder b=new StringBuilder(inputString.substring(seperater[0],seperater[1]));
            StringBuilder c=new StringBuilder(inputString.substring(seperater[1]));
            StringBuilder abc=new StringBuilder();
            abc.append(a.reverse()).append(b.reverse()).append(c.reverse());

            if(ans.compareTo(abc.toString()) > 0){
                ans= abc.toString();
            }
        }else{
            for (int i = start; i < inputString.length(); i++) {
                seperater[index]=i;
                dfs(index+1,i+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        inputString= br.readLine().trim();
        dfs(0,1);
        System.out.println(ans);
    }
}