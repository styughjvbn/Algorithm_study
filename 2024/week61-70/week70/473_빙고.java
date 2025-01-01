import java.io.*;
import java.util.*;

class Pos{
    int i;
    int j;

    public Pos(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Main{
    static Pos[] myBoard=new Pos[25];
    static int[] nums=new int[25];
    static int[] row=new int[5];
    static int[] column=new int[5];
    static int slide1=0;
    static int slide2=0;
    public static void main(String[] args) throws IOException{
        BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        for (int i = 0; i < 5; i++) {
            stringTokenizer=new StringTokenizer(bReader.readLine());
            for (int i1 = 0; i1 < 5; i1++) {
                myBoard[Integer.parseInt(stringTokenizer.nextToken())-1]=new Pos(i,i1);
            }
        }
        for (int i = 0; i < 5; i++) {
            stringTokenizer=new StringTokenizer(bReader.readLine());
            for (int i1 = 0; i1 < 5; i1++) {
                nums[i*5+i1]=Integer.parseInt(stringTokenizer.nextToken())-1;
            }
        }
        int bingoNum=0;
        for (int i = 0; i < 25; i++) {
            Pos pos=myBoard[nums[i]];
            row[pos.i]++;
            if(row[pos.i]==5)bingoNum++;
            column[pos.j]++;
            if(column[pos.j]==5)bingoNum++;
            if(pos.i== pos.j){
                slide1++;
                if (slide1==5)bingoNum++;
            }
            if (pos.i+ pos.j==4){
                slide2++;
                if (slide2==5)bingoNum++;
            }
            if(bingoNum>=3){
                System.out.println(i+1);
                break;
            }
        }
    }
}