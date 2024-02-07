import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class StartPoint{
    static int[] di= {0,1,0,-1};
    static int[] dj= {1,0,-1,0};
    static int[][] startPos;
    static int curStart=0;
    static int horizonDir=0;
    static int verticalDir=1;
    static int N;
    static int M;
    int[][] arr;

    int tempI;
    int tempJ;

    public StartPoint(int[][] arr) {
        super();
        this.arr=arr;
    }
    public String lineToString(int line) {
        tempI=startPos[curStart][0]+di[verticalDir]*(line-1);
        tempJ=startPos[curStart][1]+dj[verticalDir]*(line-1);
        StringBuilder sb=new StringBuilder();
        while(true) {
            if(0<=tempI&& tempI<N && 0<=tempJ && tempJ<M) {
                sb.append(arr[tempI][tempJ]).append(' ');
            }else {
                if(sb.length()==0) {
                    return null;
                }
                return sb.toString();
            }
            tempI=tempI+di[horizonDir];
            tempJ=tempJ+dj[horizonDir];
        }
    }
}

public class Main {
    static int N,M,R;
    static StartPoint[] startPoints=new StartPoint[4];

    public static void printArr() {
        StringBuilder sb=new StringBuilder();

        int line=1;
        while(true) {
            String line1=startPoints[0].lineToString(line);
            String line2=startPoints[1].lineToString(line);
            if(line1==null) {
                break;
            }else {
                line++;
                sb.append(line1).append(line2).append('\n');
            }
        }
        line=1;
        while(true) {
            String line1=startPoints[3].lineToString(line);
            String line2=startPoints[2].lineToString(line);
            if(line1==null) {
                break;
            }else {
                line++;
                sb.append(line1).append(line2).append('\n');
            }
        }
        System.out.print(sb);

    }

    public static void func1() {
        swap(0,3);
        swap(1,2);
        StartPoint.verticalDir =(StartPoint.verticalDir +2)%4;
        if(StartPoint.verticalDir%2==0){
            if(StartPoint.curStart==2)StartPoint.curStart=3;
            else if(StartPoint.curStart==0)StartPoint.curStart=1;
            else if(StartPoint.curStart==1)StartPoint.curStart=0;
            else if(StartPoint.curStart==3)StartPoint.curStart=2;
        }else{
            if(StartPoint.curStart==3)StartPoint.curStart=0;
            else if(StartPoint.curStart==0)StartPoint.curStart=3;
            else if(StartPoint.curStart==1)StartPoint.curStart=2;
            else if(StartPoint.curStart==2)StartPoint.curStart=1;
        }
    }
    public static void func2() {
        swap(0,1);
        swap(2,3);
        StartPoint.horizonDir=(StartPoint.horizonDir+2)%4;
        if(StartPoint.horizonDir%2==0){
            if(StartPoint.curStart==3)StartPoint.curStart=2;
            else if(StartPoint.curStart==0)StartPoint.curStart=1;
            else if(StartPoint.curStart==1)StartPoint.curStart=0;
            else if(StartPoint.curStart==2)StartPoint.curStart=3;
        }else{
            if(StartPoint.curStart==3)StartPoint.curStart=0;
            else if(StartPoint.curStart==0)StartPoint.curStart=3;
            else if(StartPoint.curStart==1)StartPoint.curStart=2;
            else if(StartPoint.curStart==2)StartPoint.curStart=1;
        }
    }
    public static void func3() {
        StartPoint temp=startPoints[0];
        startPoints[0]=startPoints[3];
        startPoints[3]=startPoints[2];
        startPoints[2]=startPoints[1];
        startPoints[1]=temp;
        if(StartPoint.horizonDir==0 &&StartPoint.verticalDir==1||
                StartPoint.horizonDir==1 &&StartPoint.verticalDir==2||
                StartPoint.horizonDir==2 &&StartPoint.verticalDir==3||
                StartPoint.horizonDir==3 &&StartPoint.verticalDir==0){
            StartPoint.verticalDir=((StartPoint.verticalDir-1)+4)%4;
            StartPoint.horizonDir=((StartPoint.horizonDir-1)+4)%4;
            StartPoint.curStart=((StartPoint.curStart-1)+4)%4;

        }else{
            StartPoint.verticalDir=(StartPoint.verticalDir+1)%4;
            StartPoint.horizonDir=(StartPoint.horizonDir+1)%4;
            StartPoint.curStart=(StartPoint.curStart+1)%4;
        }
    }
    public static void func4() {
        StartPoint temp=startPoints[0];
        startPoints[0]=startPoints[1];
        startPoints[1]=startPoints[2];
        startPoints[2]=startPoints[3];
        startPoints[3]=temp;

        if(StartPoint.horizonDir==0 &&StartPoint.verticalDir==1||
                StartPoint.horizonDir==1 &&StartPoint.verticalDir==2||
                StartPoint.horizonDir==2 &&StartPoint.verticalDir==3||
                StartPoint.horizonDir==3 &&StartPoint.verticalDir==0){
            StartPoint.verticalDir=(StartPoint.verticalDir+1)%4;
            StartPoint.horizonDir=(StartPoint.horizonDir+1)%4;
            StartPoint.curStart=(StartPoint.curStart+1)%4;
        }else{
            StartPoint.verticalDir=((StartPoint.verticalDir-1)+4)%4;
            StartPoint.horizonDir=((StartPoint.horizonDir-1)+4)%4;
            StartPoint.curStart=((StartPoint.curStart-1)+4)%4;
        }
    }
    public static void func5() {
        StartPoint temp=startPoints[0];
        startPoints[0]=startPoints[3];
        startPoints[3]=startPoints[2];
        startPoints[2]=startPoints[1];
        startPoints[1]=temp;
    }
    public static void func6() {
        StartPoint temp=startPoints[0];
        startPoints[0]=startPoints[1];
        startPoints[1]=startPoints[2];
        startPoints[2]=startPoints[3];
        startPoints[3]=temp;
    }
    public static void swap(int a,int b) {
        StartPoint temp=startPoints[a];
        startPoints[a]=startPoints[b];
        startPoints[b]=temp;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        int[][][] areas=new int[4][N/2][M/2];
        for (int i = 0; i < N/2; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < M/2; j++) {
                areas[0][i][j]=Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < M/2; j++) {
                areas[1][i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N/2; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < M/2; j++) {
                areas[3][i][j]=Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < M/2; j++) {
                areas[2][i][j]=Integer.parseInt(st.nextToken());
            }
        }

        StartPoint.N=N/2;
        StartPoint.M=M/2;
        StartPoint.startPos=new int[][] {{0,0},{0,M/2-1},{N/2-1,M/2-1},{N/2-1,0}};
        for (int i = 0; i < 4; i++) {
            startPoints[i]=new StartPoint(areas[i]);
        }

        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int oper=Integer.parseInt(st.nextToken());
            switch (oper) {
                case 1:
                    func1();
                    break;
                case 2:
                    func2();
                    break;
                case 3:
                    func3();
                    break;
                case 4:
                    func4();
                    break;
                case 5:
                    func5();
                    break;
                case 6:
                    func6();
                    break;

                default:
                    break;
            }
        }
        printArr();
    }
}
