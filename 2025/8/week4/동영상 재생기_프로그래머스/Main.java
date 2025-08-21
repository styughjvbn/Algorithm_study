import java.util.*;
import java.io.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Video video = new Video(
                Player.convertTimeToInt(op_start),
                Player.convertTimeToInt(op_end),
                Player.convertTimeToInt(video_len),
                Player.convertTimeToInt(pos)
        );
        Player.play(video, commands);
        String answer = Player.convertTimeToString(video.curTime);
        return answer;
    }
}


class Video{
    int curTime;
    final int opStartTime;
    final int opEndTime;
    final int len;

    Video(int opStartTime,int opEndTime, int len, int curTime){
        this.opStartTime = opStartTime;
        this.opEndTime = opEndTime;
        this.len = len;
        this.curTime = curTime;
    }

    void next(){
        curTime += 10;
        if(curTime>len){
            curTime = len;
        }
    }

    void prev(){
        curTime-=10;
        if(curTime<0){
            curTime = 0;
        }
    }

    void skipOp(){
        if(opStartTime <= curTime && curTime <= opEndTime){
            curTime = opEndTime;
        }
    }
}


class Player{
    static StringTokenizer st;

    static void play(Video video, String[] commands){
        video.skipOp();
        for(String command: commands){
            if(command.charAt(0) == 'n'){
                video.next();
            }else{
                video.prev();
            }
            video.skipOp();
        }
    }

    static int convertTimeToInt(String time){
        st = new StringTokenizer(time,":");
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        return m*60 + s;
    }

    static String convertTimeToString(int time){
        int m = time/60;
        int s = time%60;

        return String.format("%02d:%02d",m,s);
    }
}