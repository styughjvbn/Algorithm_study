import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[][] board_hole;
    static int[][] piece;
    static int[] di={0,0,-1,1};
    static int[] dj={1,-1,0,0};
    static int result=0;
    static int k;
    public static boolean move_forward(int i,int j, int ni, int nj,int index, boolean reverse){
        int idx=board_hole[i][j].indexOf(index);
        List<Integer> remain=board_hole[i][j].subList(0,idx);
        List<Integer> moving=board_hole[i][j].subList(idx, board_hole[i][j].size());
        for (int l:moving) {
            piece[l][0]=ni;
            piece[l][1]=nj;
        }
        if(reverse){
            Collections.reverse(moving);
        }
        board_hole[ni][nj].addAll(moving);
        if(board_hole[ni][nj].size()>=4){
            System.out.println(result);
            return true;
        }else{
            board_hole[i][j]= new ArrayList(remain);
            return false;
        }
    }

    public static int change_dir(int index){
        if (piece[index][2]==1)
            piece[index][2]=0;
        else if (piece[index][2]==0)
            piece[index][2]=1;
        else if (piece[index][2]==2)
            piece[index][2]=3;
        else if (piece[index][2]==3)
            piece[index][2]=2;
        return piece[index][2];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        k= Integer.parseInt(st.nextToken());
        int[][] board=new int[n][n];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        board_hole=new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board_hole[i][j]=new ArrayList<Integer>();
            }
        }
        piece=new int[k][3];
        for (int i = 0; i < k; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            int c=Integer.parseInt(st.nextToken())-1;
            board_hole[a][b].add(i);
            piece[i][0]=a;
            piece[i][1]=b;
            piece[i][2]=c;
        }
        boolean flag=false;
        while(result<=1000){
            result+=1;
            flag=false;
            for (int iii = 0; iii < k; iii++) {
                int i=piece[iii][0];
                int j=piece[iii][1];
                int d=piece[iii][2];
                int ni=i+di[d];
                int nj=j+dj[d];
                if(ni>=0 && ni<n && nj>=0 && nj<n){
                    if(board[ni][nj]==0){
                        flag=move_forward(i,j,ni,nj,iii,false);
                    } else if (board[ni][nj]==1) {
                        flag=move_forward(i,j,ni,nj,iii,true);
                    }
                    else{
                        int pre_dir=change_dir(iii);
                        ni=i+di[pre_dir];
                        nj=j+dj[pre_dir];
                        if (ni>=0 && ni<n && nj>=0 && nj<n && board[ni][nj]!=2){
                            if(board[ni][nj]==0){
                                flag=move_forward(i,j,ni,nj,iii,false);
                            }else{
                                flag=move_forward(i,j,ni,nj,iii,true);
                            }
                        }
                    }
                }else{
                    int pre_dir=change_dir(iii);
                    ni=i+di[pre_dir];
                    nj=j+dj[pre_dir];
                    if (ni>=0 && ni<n && nj>=0 && nj<n && board[ni][nj]!=2){
                        if(board[ni][nj]==0){
                            flag=move_forward(i,j,ni,nj,iii,false);
                        }else{
                            flag=move_forward(i,j,ni,nj,iii,true);
                        }
                    }
                }

                if(flag){
                    return;
                }
            }

        }
        System.out.println(-1);
        return;
    }
}