import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

class Movements{
    int sec;
    int dir;

    public Movements(int sec, char dir) {
        this.sec = sec;
        if(dir=='L') {
            this.dir = -1;
        }else {
            this.dir = 1;
        }
    }
}

class Pos{
    int i;
    int j;

    public Pos(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "Pos [i=" + i + ", j=" + j + "]";
    }
}

class SnakePos extends Pos{
    int dir;

    public SnakePos(Pos pos, int dir) {
        super(pos.i, pos.j);
        this.dir = dir;
    }

    public SnakePos(int i, int j, int dir) {
        super(i, j);
        this.dir = dir;
    }
}

class Snake{
    static int[] di= {0,1,0,-1};
    static int[] dj= {1,0,-1,0};
    Deque<SnakePos> trace=new ArrayDeque<>();

    public Snake() {
        trace.add(new SnakePos(0,0,0));
    }
    Pos move(SnakePos pos, boolean exitsApple) {
        trace.add(pos);
        if(exitsApple) {
            return null;
        }
        return trace.pollFirst();
    }
    Pos nextPos(int dir) {
        SnakePos curFirstPos= trace.getLast();
        int nDir=(curFirstPos.dir+dir+4)%4;
        return new SnakePos(curFirstPos.i+di[nDir],curFirstPos.j+dj[nDir], nDir);
    }
    Pos getTailPos() {
        return trace.getFirst();
    }
    void print() {
        System.out.println(trace.size());
    }
}

class GameManager{
    int[][] board;
    Snake snake;

    public GameManager(int[][] board) {
        this.board = board;
        board[0][0]=1;
        this.snake = new Snake();
    }

    public boolean next(int dir) {
        Pos prevPos=snake.getTailPos();
        Pos nPos=snake.nextPos(dir);
        if(0>nPos.i || nPos.i>=board.length || 0>nPos.j || nPos.j>=board.length) {//맵 밖으로 나간경우
            return false;
        }else if(board[nPos.i][nPos.j]==1) {//뱀의 몸일 경우
            return false;
        }else if(board[nPos.i][nPos.j]==2) {//사과일 경우
            snake.move((SnakePos)nPos, true);
        }else {
            snake.move((SnakePos)nPos, false);
            board[prevPos.i][prevPos.j]=0;
        }
//		snake.print();
        board[nPos.i][nPos.j]=1;
//		printState();
        return true;
    }

    public void printState() {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int n=Integer.parseInt(bufferedReader.readLine());
        int[][] board=new int[n][n];
        int k=Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < k; i++) {
            stringTokenizer=new StringTokenizer(bufferedReader.readLine());
            board[Integer.parseInt(stringTokenizer.nextToken())-1][Integer.parseInt(stringTokenizer.nextToken())-1]=2;
        }
        int l=Integer.parseInt(bufferedReader.readLine());
        Movements[] movements=new Movements[l];
        for (int i = 0; i < l; i++) {
            stringTokenizer=new StringTokenizer(bufferedReader.readLine());
            movements[i]=new Movements(Integer.parseInt(stringTokenizer.nextToken()), stringTokenizer.nextToken().charAt(0));
        }
        GameManager gameManager=new GameManager(board);
        int time=0;
        int moveIndex=0;
        while (true) {
            boolean res;
            if(moveIndex<movements.length&& movements[moveIndex].sec==time) {
                res=gameManager.next(movements[moveIndex].dir);
                moveIndex++;
            }else {
                res=gameManager.next(0);
            }
            if(!res)break;
            time++;
        }
        System.out.println(time+1);
    }
}