import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        char[][] strings=new char[m][n];
        for (int i = n-1; i >=0; i--) {
            char[] ss=br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                strings[j][i]=ss[j];
            }
        }
        String[] stringsList=new String[m];
        for (int i = 0; i < m; i++) {
            stringsList[i]=new String(strings[i]);
        }

        for (int i = 1; i < n; i++) {
            Set<String> set=new HashSet<>(m);
            for (int i1 = 0; i1 < m; i1++) {
                if(!set.add(stringsList[i1].substring(0,n-i))){
                    System.out.println(i-1);
                    return;
                }
            }
        }
        System.out.println(n-1);
//        for (int i = 0; i < m; i++) {
//            String temp=new String(strings[i]);
//
//            for (int j = n; j >=1; j--) {
//                if(!setList[j-1].add(temp.substring(0,j))){
//                    System.out.println(n-1-(n-j));
//                    return;
//                }
//            }
//        }
//
//        System.out.println(n-1);


    }
}