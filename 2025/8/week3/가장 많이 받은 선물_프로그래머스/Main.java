import java.util.*;
import java.io.*;

class Solution {
    StringTokenizer st;
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> friendStringToInt = new HashMap();
        int idx =0 ;
        for(String friend:friends){
            friendStringToInt.put(friend,idx++);
        }
        int[][] giftTransferStat = new int[idx][idx];
        int[][] giftScore = new int[idx][2];//0 = 준 선물의 수 , 1 = 받은 선물의 수

        for(String gift:gifts){
            st = new StringTokenizer(gift," ");
            int friendANum = friendStringToInt.get(st.nextToken());
            int friendBNum = friendStringToInt.get(st.nextToken());
            giftTransferStat[friendANum][friendBNum]++;
            giftScore[friendANum][0]++;
            giftScore[friendBNum][1]++;
        }

        int[] nextMonRecieveCount = new int[idx];
        for(int i =0;i<idx;i++){
            for(int j =i+1;j<idx;j++){
                if(giftTransferStat[i][j] != giftTransferStat[j][i]){
                    if(giftTransferStat[i][j] > giftTransferStat[j][i]){
                        nextMonRecieveCount[i]++;
                    }else{
                        nextMonRecieveCount[j]++;
                    }
                }else{
                    int giftScoreA = giftScore[i][0] - giftScore[i][1];
                    int giftScoreB = giftScore[j][0] - giftScore[j][1];
                    if(giftScoreA == giftScoreB) continue;
                    if(giftScoreA>giftScoreB){
                        nextMonRecieveCount[i]++;
                    }else{
                        nextMonRecieveCount[j]++;
                    }
                }
            }
        }

        int answer = 0;
        for(int count : nextMonRecieveCount){
            if(answer<count){
                answer = count;
            }
        }

        return answer;
    }
}