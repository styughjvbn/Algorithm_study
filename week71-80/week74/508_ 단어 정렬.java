import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        Set<String> stringSet=new HashSet<>();
        for (int i = 0; i < n; i++) {
            stringSet.add(br.readLine());
        }
        String[] strings=new String[stringSet.size()];
        strings= stringSet.toArray(strings);
        Arrays.sort(strings,(a,b)->{
            if(a.length()==b.length()){
                return a.compareTo(b);
            }
            return a.length()-b.length();
        });
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]).append("\n");

        }
        System.out.println(sb);
    }
}