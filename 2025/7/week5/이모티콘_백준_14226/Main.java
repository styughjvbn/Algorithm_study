import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int MAX_VISIT = 2050;

    public static void main(String[] args) throws IOException {
        int s = Integer.parseInt(br.readLine());
        if(s == 2){
            System.out.println(2);
            System.exit(0);
        }
        Deque<int[]> deque = new ArrayDeque<>();
        int curEmojiCount = 2;
        int curClipboard = 1;
        int curTime = 2;
        deque.add(new int[]{curEmojiCount, curClipboard});
        int[][] visit = new int[MAX_VISIT][MAX_VISIT];
        visit[curEmojiCount][curClipboard] = curTime;
        while(!deque.isEmpty()){
            int[] metaData = deque.pollFirst();
            curEmojiCount = metaData[0];
            curClipboard = metaData[1];
            curTime = visit[curEmojiCount][curClipboard];
            if(curEmojiCount+curClipboard < MAX_VISIT && visit[curEmojiCount+curClipboard][curClipboard] == 0){//클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
                visit[curEmojiCount+curClipboard][curClipboard] = curTime + 1;
                deque.add(new int[]{curEmojiCount+curClipboard, curClipboard});
                findTarget(curEmojiCount+curClipboard, s, curTime + 1);
            }
            if(visit[curEmojiCount][curEmojiCount] == 0){//화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
                visit[curEmojiCount][curEmojiCount] = curTime + 1;
                deque.add(new int[]{curEmojiCount, curEmojiCount});
                findTarget(curEmojiCount, s, curTime + 1);
            }
            if(curEmojiCount > 2 && visit[curEmojiCount -1][curClipboard] == 0){//화면에 있는 이모티콘 중 하나를 삭제
                visit[curEmojiCount - 1][curClipboard] = curTime + 1;
                deque.add(new int[]{curEmojiCount - 1, curClipboard});
                findTarget(curEmojiCount - 1, s, curTime + 1);
            }
        }
    }

    public static void findTarget(int curEmojiCount, int targetEmojiCount, int time){
        if(curEmojiCount == targetEmojiCount){
            System.out.println(time);
            System.exit(0);
        }
    }
}