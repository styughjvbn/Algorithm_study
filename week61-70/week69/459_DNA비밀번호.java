import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int s=Integer.parseInt(st.nextToken());
        int p=Integer.parseInt(st.nextToken());

        String inputString=br.readLine().strip();

        st=new StringTokenizer(br.readLine());
        int[] wantNum=new int[4];
        for (int i=0;i<4 ;i++ ) {
            wantNum[i]=Integer.parseInt(st.nextToken());
        }


        int result=0;
        int[] stringNum=new int[4];
        for (int j = 0; j < p; j++) {
            if(inputString.charAt(j)=='A'){
                stringNum[0]++;
            }else if(inputString.charAt(j)=='C'){
                stringNum[1]++;
            }else if(inputString.charAt(j)=='G'){
                stringNum[2]++;
            }else if(inputString.charAt(j)=='T'){
                stringNum[3]++;
            }
        }
        boolean isOK=true;
        for (int i1 = 0; i1 < 4; i1++) {
            if(wantNum[i1]>stringNum[i1]){
                isOK=false;
                break;
            }
        }
        if(isOK)result++;

        int start=0;
        int end=p;
        for (int i=1;i<s-p+1;i++ ) {
            if(inputString.charAt(start)=='A'){
                stringNum[0]--;
            }else if(inputString.charAt(start)=='C'){
                stringNum[1]--;
            }else if(inputString.charAt(start)=='G'){
                stringNum[2]--;
            }else if(inputString.charAt(start)=='T'){
                stringNum[3]--;
            }
            if(inputString.charAt(end)=='A'){
                stringNum[0]++;
            }else if(inputString.charAt(end)=='C'){
                stringNum[1]++;
            }else if(inputString.charAt(end)=='G'){
                stringNum[2]++;
            }else if(inputString.charAt(end)=='T'){
                stringNum[3]++;
            }

            isOK=true;
            for (int i1 = 0; i1 < 4; i1++) {
                if(wantNum[i1]>stringNum[i1]){
                    isOK=false;
                    break;
                }
            }
            if(isOK)result++;
            start++;
            end++;
        }
        System.out.println(result);
    }
}