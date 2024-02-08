import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            StringTokenizer start=new StringTokenizer(st.nextToken(),":");
            int hStart=Integer.parseInt(start.nextToken());
            int mStart=Integer.parseInt(start.nextToken());
            int sStart=Integer.parseInt(start.nextToken());
            StringTokenizer end=new StringTokenizer(st.nextToken(),":");
            int hEnd=Integer.parseInt(end.nextToken());
            int mEnd=Integer.parseInt(end.nextToken());
            int sEnd=Integer.parseInt(end.nextToken());
            int ans=0;
            while(true){
                if((hStart*10000+mStart*100+sStart)%3==0){
                    ans++;
                }
                sStart+=1;
                if(sStart==60){
                    sStart=0;
                    mStart+=1;
                    if (mStart==60){
                        mStart=0;
                        hStart+=1;
                        if (hStart==24){
                            hStart=0;
                        }
                    }
                }
                if((hStart==hEnd && mStart==mEnd&& sStart==sEnd)){
                    if((hStart*10000+mStart*100+sStart)%3==0){
                        ans++;
                    }
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}