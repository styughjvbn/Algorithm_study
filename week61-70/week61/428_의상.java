import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map=new HashMap<>();
        for(String[] clothe:clothes){
            map.put(clothe[1],map.getOrDefault(clothe[1],0)+1);
        }
        for(int num:map.values()){
            answer*=num+1;
            System.out.println(num);
        }
        return answer-1;
    }
}