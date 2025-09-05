import java.util.*;

class Solution {
    List<int[]> result = new ArrayList();

    public int[][] solution(int n) {
        move(n, 1, 2, 3);
        return result.toArray(new int[result.size()][]);
    }

    public void move(int depth, int cur, int other, int target){
        if(depth == 1){
            result.add(new int[]{cur, target});
            return;
        }
        move(depth-1, cur, target, other);
        result.add(new int[]{cur, target});
        move(depth-1, other, cur, target);
    }
}