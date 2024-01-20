import java.io.*;
import java.util.*;

class Carrot implements Comparable<Carrot>{
    int initTaste;
    int plusTaste;

    public Carrot(int initTaste, int plusTaste) {
        this.initTaste = initTaste;
        this.plusTaste = plusTaste;
    }

    @Override
    public int compareTo(Carrot o) {
        // TODO Auto-generated method stub
        if(this.plusTaste==o.plusTaste) {
            return o.initTaste-this.initTaste;
        }else {
            return o.plusTaste-this.plusTaste;
        }
    }

}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer=new StringTokenizer(bReader.readLine());
        int n=Integer.parseInt(stringTokenizer.nextToken());
        long t=Integer.parseInt(stringTokenizer.nextToken());
        Carrot[] carrots=new Carrot[n];
        for (int i = 0; i < n; i++) {
            stringTokenizer=new StringTokenizer(bReader.readLine());
            int w=Integer.parseInt(stringTokenizer.nextToken());
            int p=Integer.parseInt(stringTokenizer.nextToken());
            carrots[i]=new Carrot(w,p);
        }
        Arrays.sort(carrots);
        long ans=0;
        for (int i = 0; i < n; i++) {
            ans+=(t-1-i)*carrots[i].plusTaste+carrots[i].initTaste;
        }
        System.out.println(ans);
    }
}