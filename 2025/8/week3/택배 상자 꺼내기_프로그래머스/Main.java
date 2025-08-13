class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int fullFloorCount = n/w;
        int remainFloorBoxCount = n%w;

        int targetFloor = (num-1)/w;
        int targetPosition = ((num-1)%w)+1;

        answer += fullFloorCount-targetFloor;
        System.out.println(answer);
        if(fullFloorCount%2==targetFloor%2){
            if(remainFloorBoxCount>=targetPosition)answer++;
        }else{
            if(w-remainFloorBoxCount<targetPosition)answer++;
        }
        return answer;
    }
}