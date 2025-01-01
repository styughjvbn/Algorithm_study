import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class User{
    static int[] di= {0,-1,0,1,0};
    static int[] dj= {0,0,1,0,-1};
    int i;
    int j;
    int status;
    int[] moveInfo;
}

public class Main {
    static int m;
    static int a;
    static int[][] map;
    static int total;
    static User[] users=new User[2];
    static int[] di= {0,1,0,-1};
    static int[] dj= {1,0,-1,0};
    private static int[][] apInfo;

    public static void move(int t) {
        for (int i = 0; i < 2; i++) {
            users[i].i+=User.di[users[i].moveInfo[t]];
            users[i].j+=User.dj[users[i].moveInfo[t]];
            users[i].status=map[users[i].i][users[i].j];
        }
        if(users[0].status==0 && users[1].status==0)return;
        int aa=users[0].status&users[1].status;
        int b=users[0].status|users[1].status;
//        System.out.println(aa+" "+b);
        if(aa==0) {//안 겹칠때
            int max0=0;
            int max1=0;
            for (int i = a-1; i >=0; i--) {
                if(max0==0&&((users[0].status&(1<<i))!=0)) {
                    max0=apInfo[i][3];
                }
                if(max1==0&&((users[1].status&(1<<i))!=0)) {
                    max1=apInfo[i][3];
                }
            }

            total+=max1+max0;
        }else {//겹칠때

            int sumB=0;
            int max0=0;
            int max1=0;
            int tempMax=0;
            for (int i = a-1; i >=0; i--) {
                if(((users[0].status&(1<<i))!=0)) {
                    max0=apInfo[i][3];
                    for (int j = a-1; j >=0 ; j--) {
                        if(i==j)continue;
                        if(((users[1].status&(1<<j))!=0)) {
                            max1=apInfo[j][3];
                            break;
                        }
                    }
                    tempMax=Math.max(tempMax,max1+max0);
                }
            }
            for (int i = a-1; i >=0; i--) {
                if((aa&(1<<i))!=0) {
                    sumB=apInfo[i][3];
                    break;
                }
            }
//            System.out.println("jijoi "+max0+" "+max1+" "+users[0].status+" "+users[1].status);
            total+=Math.max(tempMax, sumB);
        }
//        System.out.println(total);
    }

    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            total=0;
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            m=Integer.parseInt(st.nextToken());
            a=Integer.parseInt(st.nextToken());
            for (int i = 0; i < 2; i++) {
                int[] moveInfo=new int[m+1];
                moveInfo[0]=0;
                String line=br.readLine();
                for (int j = 0; j < m; j++) {
                    moveInfo[j+1]=line.charAt(j*2)-'0';
                }
                users[i]=new User();
                users[i].moveInfo=moveInfo;
            }
            users[1].i=9;
            users[1].j=9;
            map=new int[10][10];
            apInfo=new int[a][4];
            for (int i = 0; i < apInfo.length; i++) {
                st=new StringTokenizer(br.readLine());
                for (int j = 1; j >=0 ; j--) {
                    apInfo[i][j]=Integer.parseInt(st.nextToken())-1;
                }
                for (int j = 2; j < 4; j++) {
                    apInfo[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            Arrays.sort(apInfo, Comparator.comparingInt(a -> a[3]));
            for (int i = 0; i < apInfo.length; i++) {
                Deque<int[]> queue=new ArrayDeque<>();
                queue.add(new int[] {apInfo[i][0],apInfo[i][1],1});
                map[apInfo[i][0]][apInfo[i][1]]|=(1<<i);
                while(!queue.isEmpty()) {
                    int[] cur=queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int ni=cur[0]+di[k];
                        int nj=cur[1]+dj[k];
                        if(0<=ni && ni< 10 && 0<=nj && nj<10 && (map[ni][nj]&(1<<i))==0) {
                            map[ni][nj]|=(1<<i);
                            if(cur[2]<apInfo[i][2]) {
                                queue.add(new int[] {ni,nj,cur[2]+1});
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < m+1; i++) {
                move(i);
            }
            sb.append("#").append(t).append(" ").append(total).append("\n");
//            for (int i = 0; i < 10; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
        }
        System.out.println(sb);
    }

}

