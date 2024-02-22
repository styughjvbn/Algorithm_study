import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        HashMap<String,Integer> String2Integer= new HashMap<>();
        HashMap<Integer,String> Integer2String= new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line=br.readLine();
            String2Integer.put(line,i+1);
            Integer2String.put(i+1,line);
        }
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < m; i++) {
            String line=br.readLine();
            try{
                sb.append(Integer2String.get(Integer.parseInt(line)));
            }catch(NumberFormatException e){
                sb.append(String2Integer.get(line));
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}