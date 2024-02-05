import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a,b;
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        char[][] board=new char[a][b];
        for (int i = 0; i < a; i++) {
            String string=br.readLine();
            for (int i1 = 0; i1 < b; i1++) {
                board[i][i1]=string.charAt(i1);
            }
        }
        StringBuilder sb=new StringBuilder();
        String ans="zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        for (int i = 0; i < a; i++) {
            sb.setLength(0);
            for (int i1 = 0; i1 < b; i1++) {
                if(board[i][i1]!='#'){
                    sb.append(board[i][i1]);
                }else{
                    if(sb.length()>1){
                        if(ans.compareTo(sb.toString())>0){
                            ans= sb.toString();
                        }
                    }
                    sb.setLength(0);
                }
            }
            if(sb.length()>1){
                if(ans.compareTo(sb.toString())>0){
                    ans= sb.toString();
                }
            }
        }
        for (int i = 0; i < b; i++) {
            sb.setLength(0);
            for (int i1 = 0; i1 < a; i1++) {
                if(board[i1][i]!='#'){
                    sb.append(board[i1][i]);
                }else{
                    if(sb.length()>1){
                        if(ans.compareTo(sb.toString())>0){
                            ans= sb.toString();
                        }
                    }
                    sb.setLength(0);
                }
            }
            if(sb.length()>1){
                if(ans.compareTo(sb.toString())>0){
                    ans= sb.toString();
                }
            }
        }
        System.out.println(ans);
    }
}