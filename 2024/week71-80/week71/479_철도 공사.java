import java.util.*;
import java.io.*;

class LinkedList{
    int start=-1;
    StringBuilder sb=new StringBuilder();
    int[] prev=new int[1000001];
    int[] next=new int[1000001];


    public void addBack(int insertNum){
        if(start==-1){
            next[insertNum]=insertNum;
            prev[insertNum]=insertNum;
            start=insertNum;
        }else{
            next[insertNum]=start;
            prev[insertNum]=prev[start];
            next[prev[start]]=insertNum;
            prev[start]=insertNum;
        }
    }
    public void add(int baseNum, int insertNum, boolean addNext){
        if(addNext){
            sb.append(next[baseNum]);
            sb.append("\n");
            next[insertNum]=next[baseNum];
            prev[insertNum]=baseNum;
            prev[next[baseNum]]=insertNum;
            next[baseNum]=insertNum;
        }else{
            sb.append(prev[baseNum]);
            sb.append("\n");
            prev[insertNum]=prev[baseNum];
            next[insertNum]=baseNum;
            next[prev[baseNum]]=insertNum;
            prev[baseNum]=insertNum;
        }
    }
    public void delete(int deleteNum, boolean deleteNext){
        if(deleteNext){
            sb.append(next[deleteNum]);
            sb.append("\n");
            prev[next[next[deleteNum]]]=deleteNum;
            next[deleteNum]=next[next[deleteNum]];
        }else{
            sb.append(prev[deleteNum]);
            sb.append("\n");
            next[prev[prev[deleteNum]]]=deleteNum;
            prev[deleteNum]=prev[prev[deleteNum]];
        }
    }
}


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        LinkedList LL=new LinkedList();
        for (int i = 0; i < n; i++) {
            LL.addBack(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "BN" -> LL.add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), true);
                case "BP" -> LL.add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), false);
                case "CP" -> LL.delete(Integer.parseInt(st.nextToken()), false);
                case "CN" -> LL.delete(Integer.parseInt(st.nextToken()), true);
            }
        }
//        LL.printStatus();
        System.out.println(LL.sb.toString());
    }
}